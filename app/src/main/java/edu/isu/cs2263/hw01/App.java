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

import org.apache.commons.cli.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Main app class for the program
 *
 * @author Isaac D Griffith
 * @version 1.1.0
 */
public class App {

    /**
     * Main method which runs the program
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Evaluator eval = new Evaluator();
        InputMode inMode = new InteractiveInputMode();

        Options options = new Options();

        Option batch = Option.builder("b").longOpt("batch").argName("file").hasArg().desc("batch file containing expressions to evaluate").build();
        Option output = Option.builder("o").longOpt("output").argName("file").hasArg().desc("output file").build();
        Option help = Option.builder("h").longOpt("help").desc("print usage message").build();

        options.addOption(batch);
        options.addOption(help);
        options.addOption(output);

        CommandLineParser parser = new DefaultParser();
        try {
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);

            if (line.hasOption("help")) {
                printHelp(options);
                System.exit(0);
            }

            if (line.hasOption("batch")) {
                String file = line.getOptionValue("batch");
                Path path = Paths.get(file);
                if (Files.exists(path)) {
                    inMode = new BatchInputMode(path);
                } else {
                    System.out.println("The provided file for the batch input mode does not exist.");
                    System.out.println();
                    printHelp(options);
                    System.exit(1);
                }
            }

            if (line.hasOption("output")) {
                System.out.println("Output value: " + line.getOptionValue("output"));
            }
        } catch(ParseException exp) {
            System.err.println("Parsing failed. Reason: " + exp.getMessage());
        }

        System.out.println("");
        inMode.processInput(eval);
    }

    /**
     * Helper method to print the help/usage message
     *
     * @param options The command line options object
     */
    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("eval [OPTIONS]", "Evaluation of simple mathematical expressions\n\n", options, "\nCopyright (C) 2021 Isaac D. Griffith");
    }
}


