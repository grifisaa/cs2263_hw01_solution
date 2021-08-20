# CS 2263 Homework 01 - Solution

This project aimed to give students a refresher in Java while also to give practical experience in using Gradle, Git, GitHub, and GitFlow.
The project was to implement a simple mathematical expression evaluator (without worrying about order of operations), allowing students to
use multiple classes, interfaces, inheritance, and to work with libraries that they have never explored.

# Table of Contents

* [Installation](#installation)
* [Usage](#usage)
  - [Interactive Mode](#interactive-mode)
  - [Batch Mode](#batch-mode)
  - [Output Modes](#output-modes)
* [Contributing](#contributing)
* [Credits](#credits)
* [License](#license)

# Installation

Very simple install.

1. Clone the repo.
2. Run `gradle assemble`
3. Copy the file `app/build/distributions/eval.zip` to where you would like it to be installed
4. Unzip `eval.zip`

# Usage

Once installed, the tool is very simple to use. There are two primary input modes: Interactive and Batch.

### Interactive Mode
The interactive mode operates on a loop until the user kills the program. Essentially, it provides a `>` prompt at which the user enters the
expression to be evaluated followed by pressing enter/return. The expression is then processed and the result returned and displayed following an `->`.
For example:

```
$ eval

> 4 + 5 + 6
  -> 15
> 1 / 4 * 4 - 1
  -> 0
  
Ctrl-C
```

### Batch Mode
The latter is activated by using the `batch` command line option using either the `-b` or `--batch` flag and providing a file name from which expressions are read. For example

```bash
eval --batch batch.txt
```

Where `batch.txt` looks something like the following

```
4 + 5 + 6
1 / 4 * 4 - 1
```

Execution of the batch mode will continue until all expressions are evaluated, and then the program will quit.

Thus, the example from above would look something like the following

```
eval --batch batch.txt

> 4 + 5 + 6
  -> 15
> 1 / 4 * 4 - 1
  -> 0
```

### Output modes

Just as there are two input modes there are also two output modes: Standard Output and Standard Output + File mode.

In the former mode, all output is direct only to the console, and resembles what is shown in the examples above. The latter
mode is activated using the `output` command line option (using `-o` or `--output`) and providing the name of a file to store the output to. Again, this
mode will output to the console, but will also output to the provided file. Note, if the file already exists it will be overwritten
and if it does not exist it will be created.

An example would be the following:

```
eval --output output.txt

> 4 + 5 + 6
  -> 15
> 1 / 4 * 4 - 1
  -> 0
```

The file `output.txt` would then look something like:

```
4 + 5 + 6
  -> 15
1 / 4 * 4 - 1
  -> 0
```

# Contributing

There is no means for others to contribute to this repository.

# Credits

This program was created by Isaac D. Griffith

# License

Copyright 2021 Isaac D. Griffith

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.