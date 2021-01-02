package it.unibo.big;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class TestMapReduce {
    private final static IntWritable one = new IntWritable(1);

    public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        protected Text word = new Text();

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                word.set(tokenizer.nextToken());
                context.write(word, one);
            }
        }
    }

    public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            context.write(key, new IntWritable(sum));
        }
    }

    @Test
    public void testReducer() {
        try {
            WordCountReducer reducer = new WordCountReducer();
            Reducer.Context context = mock(Reducer.Context.class);
            List<IntWritable> values = Arrays.asList(new IntWritable(1), new IntWritable(4), new IntWritable(7));
            reducer.reduce(new Text("foo"), values, context);
            verify(context).write(new Text("foo"), new IntWritable(12));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMapper() {
        try {
            WordCountMapper mapper = new WordCountMapper();
            Mapper.Context context = mock(Mapper.Context.class);
            mapper.word = mock(Text.class);

            mapper.map(new LongWritable(1L), new Text("foo"), context);

            InOrder inOrder = inOrder(mapper.word, context);
            assertCountedOnce(mapper, context, inOrder, "foo");

            mapper.map(new LongWritable(1L), new Text("one two three four"), context);

            inOrder = inOrder(mapper.word, context, mapper.word, context, mapper.word, context, mapper.word, context);

            assertCountedOnce(mapper, context, inOrder, "one");
            assertCountedOnce(mapper, context, inOrder, "two");
            assertCountedOnce(mapper, context, inOrder, "three");
            assertCountedOnce(mapper, context, inOrder, "four");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    private void assertCountedOnce(WordCountMapper mapper, Mapper.Context context, InOrder inOrder, String w) throws IOException, InterruptedException {
        inOrder.verify(mapper.word).set(eq(w));
        inOrder.verify(context).write(eq(mapper.word), eq(one));
    }
}
