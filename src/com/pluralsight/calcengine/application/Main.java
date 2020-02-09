package com.pluralsight.calcengine.application;

import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.deprecated.CalculateHelper;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.deprecated.MathEquation;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.exceptions.InvalidStatementException;
import com.pluralsight.calcengine.operators.Adder;
import com.pluralsight.calcengine.operators.Divider;
import com.pluralsight.calcengine.operators.Multiplier;
import com.pluralsight.calcengine.operators.PowerOf;
import com.pluralsight.calcengine.operators.Subtractor;
import org.w3c.dom.html.HTMLDivElement;

public class Main {

    public static void main(String[] args) {

        String[] statements = {

            "add 50.0 0",
            "add 50.0 2.0",
            "add 1.0",
            "add xx 25.0",
            "add X 0.0 0.0",
            "divide 100.0 50.0",
            "add 25.0 92.0",
            "subtract 225.0 17.0",
            "ded 11.0 3.0"
        };

        /*
        * Interfaces!
        */

        System.out.println(" --- The power of interfaces! --- ");

        DynamicHelper newHelper = new DynamicHelper(new MathProcessing[] {
            new Subtractor(),
            new PowerOf(),
            new Adder(),
            new Divider()
        });
        for(String statement : statements) {
            try {
                String output = newHelper.process(statement);
                System.out.println(output);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("- Original exception " + e.getCause().getMessage());
                }
            }
        }

        /*
        *  New data types, error handling & string manipulation.
        */

        System.out.println(" --- New data types, error handling & string manipulation! --- ");

        CalculateHelper helper = new CalculateHelper();
        for (String statement : statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("- Original exception: " + e.getCause().getMessage());
                }
            }
        }

        /*
         * Using classes, instances, accessors & methods.
         */

        System.out.println(" --- Using classes, instances, accessors & methods! --- ");

        MathEquation testEquation = new MathEquation('a');
        testEquation.execute(100, 200);
        System.out.println("A: " + testEquation.getResult());

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('a', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('s', 11.0d, 3.0d);

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("B: " + equation.getResult());
        }

        MathEquation testEquationSecond = new MathEquation('a', 100, 50);
        testEquationSecond.execute();
        System.out.println("C: " + testEquationSecond.getResult());

        /*
         * Using inheritance and abstraction.
         */

        System.out.println(" --- Using inheritance! --- ");

        CalculateBase[] calculators = {
            new Adder(10, 50),
            new Subtractor(100, 50),
            new Divider(1337, 2),
            new Multiplier(4, 4)
        };

        for (CalculateBase calculator : calculators) {
            calculator.calculate();
            System.out.println("D: " + calculator.getResult());
        }
    }
}