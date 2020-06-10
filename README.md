# BIG - Standard project configuration (your repo name here)

![build passing](https://travis-ci.org/big-unibo/experimental-project.svg?branch=master)

## How to run the project

## Project structure

    datasets/   -- where datasets are stored
    outputs/    -- where generated datasets are stored (should not be committed)
    results/    -- where experiment/thesis results are stored (must be committed)
    src/        -- source code

## Working on this project

Import this project as Gradle project (this is tested with IntelliJ IDEA).

### Dependency management

All Java/Scala dependencies must be managed through Gradle (`build.gradle`). See [here](https://docs.gradle.org/current/userguide/core_dependency_management.html).

> Software projects rarely work in isolation. In most cases, a project relies on reusable functionality in the form of libraries or is broken up into individual components to compose a modularized system. Dependency management is a technique for declaring, resolving and using dependencies required by the project in an automated fashion. Gradle has built-in support for dependency management and lives up to the task of fulfilling typical scenarios encountered in modern software projects. 

All Python dependencies must be managed through virtual environments. See [here](https://docs.python.org/3/library/venv.html).

> The venv module provides support for creating lightweight “virtual environments” with their own site directories, optionally isolated from system site directories. Each virtual environment has its own Python binary (which matches the version of the binary that was used to create this environment) and can have its own independent set of installed Python packages in its site directories.

    cd src/main/python
    python -m venv venv
    pip install -r requirements.txt

To activate venv in Windows (with bash shell)

    source venv/Scripts/activate

To acivate venv in Linux

    source venv/libs/activate