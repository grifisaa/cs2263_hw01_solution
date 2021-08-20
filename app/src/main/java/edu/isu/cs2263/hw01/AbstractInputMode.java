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

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Class containing common functionality for the input modes
 *
 * @author Isaac D Griffith
 * @version 1.2.0
 */
public abstract class AbstractInputMode implements InputMode {

    protected List<OutputMode> outputModes;
    protected Evaluator eval;

    /**
     * Constructs an AbstractInputMode object with the given evaluator and empty list of outputmodes
     *
     * @param eval The evaluator used to evaluate expressions
     */
    public AbstractInputMode(Evaluator eval) {
        this.eval = eval;
        outputModes = Lists.newArrayList();
    }

    /**
     * Adds the given output mode to the list of output modes used. If the provide mode is null, nothing changes.
     *
     * @param mode Output Mode object to be added.
     */
    public void addOutputMode(OutputMode mode) {
        if (mode != null) {
            outputModes.add(mode);
        }
    }

    /**
     * Handles print of output, and uses the evaluator to evaluate the expression.
     *
     * @param expr Expression to be handled
     */
    protected void printData(String expr) {
        outputModes.forEach(mode -> mode.printInput(expr, isBatch()));
        try {
            String result = eval.evaluate(expr);
            outputModes.forEach(mode -> mode.printResult(result));
        } catch (ImproperlyFormattedExpressionException ifee) {
            outputModes.forEach(mode -> mode.printResult(ifee.getMessage()));
        }
    }

    /**
     * Tests if the input mode is batch or not
     *
     * @return true if the mode is batch, false otherwise.
     */
    protected abstract boolean isBatch();
}
