package com.calculator;
import net.objecthunter.exp4j.*;

public class Calculate {
    String expression;
    public Calculate(String expression){
        this.expression = expression;
    }

    public int evaluate(){
        Expression expression = new ExpressionBuilder(this.expression).build();
        double result = expression.evaluate();
        return (int)result;
    }
}
