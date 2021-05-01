package com.example.calculate

import net.objecthunter.exp4j.ExpressionBuilder


class Model(var expression: String) {

    //Для вычисления арифметического выражения использовал готовую библиотеку


    fun evaluateArithmeticExpression(): Double {
        val ex = ExpressionBuilder(expression).build()
        val result = ex.evaluate()
        return result
    }



}