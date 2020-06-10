# BIG - Standard project configuration (your repo name here)

## How to run the project

## Project structure

    datasets/   -- where datasets are stored
    outputs/    -- where generated datasets are stored (should not be committed)
    results/    -- where experiment/thesis results are stored (must be committed)
    src/        -- source code

### Dependency management

All Java/Scala dependencies must be managed through Gradle (`build.gradle`).

All Python dependencies must be managed through virtual environments. See [](https://docs.python.org/3/library/venv.html)

> The venv module provides support for creating lightweight “virtual environments” with their own site directories, optionally isolated from system site directories. Each virtual environment has its own Python binary (which matches the version of the binary that was used to create this environment) and can have its own independent set of installed Python packages in its site directories.

    cd src/main/python
    python -m venv venv
    pip install -r requirements.txt

To activate venv in Windows (with bash shell)

    source venv/Scripts/activate

To acivate venv in Linux

    source venv/libs/activate