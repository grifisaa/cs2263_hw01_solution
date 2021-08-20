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

/**
 * Handles output to the console during processing
 *
 * @author Isaac D Griffith
 * @version 1.2.0
 */
public class ConsoleOutputMode implements OutputMode {

    /**
     * Prints the input expr to the output stream
     *
     * @param expr  Input expression
     * @param batch Indicates that this is batch processing
     */
    @Override
    public void printInput(String expr, boolean batch) {
        if (batch) {
            System.out.println("> " + expr);
        }
    }

    /**
     * Prints the results of the expression evaluation to the output stream
     *
     * @param result Results to be printed
     */
    @Override
    public void printResult(String result) {
        System.out.println("  -> " + result);
    }
}
