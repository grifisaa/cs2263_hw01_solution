/**
 * Copyright 2021 Isaac D. Griffith
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package edu.isu.cs2263.hw01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

/**
 * Handles sending output to a file
 *
 * @author Isaac D Griffith
 * @version 1.2.0
 */
public class FileOutputMode implements OutputMode {

    private Path path;

    public FileOutputMode(Path path) {
        this.path = path;
    }

    /**
     * Prints the input expr to the output stream
     *
     * @param expr  Input expression
     * @param batch Indicates that this is batch processing
     */
    @Override
    public void printInput(String expr, boolean batch) {
        appendLine(expr);
    }

    /**
     * Prints the results of the expression evaluation to the output stream
     *
     * @param result Results to be printed
     */
    @Override
    public void printResult(String result) {
        appendLine(String.format("  -> %s", result));
    }

    /**
     * Utility method to append a line of text to the end of the file denoted by the path
     *
     * @param text Line of text to be appended
     */
    private void appendLine(String text) {
        try (FileWriter fw = new FileWriter(path.toFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);) {
            pw.println(text);
        } catch (IOException ex) {

        }
    }
}
