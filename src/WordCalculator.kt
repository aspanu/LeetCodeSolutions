import java.util.*

/**
 * Created by aspanu on 2020-05-16.
 */

// Word calculator
// Support: zero -> ten, plus, times, negative
// Sample: "one plus three times four"
// Now, add support for parens: "(one plus three) times 4" --> 16

val translations = mapOf("zero" to 0, "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9, "ten" to 10)
val operandPossibilities = setOf("plus", "times")
val negative = "negative"

fun wordCalculatorPreProcessor(words: String): Int {
    var tempWords = words
    // Find parens, pass smaller version of parens through word calculator, if no parens, pass whole string through wordCalculator
    var firstParen = tempWords.indexOf('(')
    while (firstParen != -1) {
        // get its paren pair, send that sub-string to wordCalculatorPreProcessor and then remove it and replace it
        // with the integer response
        val partnerParen = findPartnerParen(tempWords, firstParen)
        val parenReplacement = wordCalculatorPreProcessor(tempWords.substring(firstParen + 1, partnerParen))
        tempWords = tempWords.replaceRange(firstParen, partnerParen + 1, parenReplacement.toString())
        firstParen = tempWords.indexOf('(')
    }

    return wordCalculator(tempWords)
}

fun findPartnerParen(words: String, firstParen: Int): Int {
    var parenNumber = 1
    for (i in firstParen + 1 until words.length) {
        if (words[i] == '(') parenNumber++
        if (words[i] == ')') {
            parenNumber--
            if (parenNumber == 0) return i
        }
    }
    // Should never happen if correct input
    return -1
}

fun wordCalculator(words: String): Int {
    // Translate from the words into numbers and operands
    var numbers = LinkedList<Int>()
    var operands = LinkedList<String>()

    var makeNegative = false

    for (word in words.split(" ")) {
        when {
            word == negative -> makeNegative = true
            operandPossibilities.contains(word) -> operands.add(word)
            word.toIntOrNull() != null -> numbers.add(word.toInt())
            else -> {
                // Has to be a number
                val number = if (makeNegative) translations[word]?.times(-1) ?: error("Translation didn't exist for: $word")
                else translations[word] ?: error("Translation didn't exist for: $word")
                numbers.add(number)
                makeNegative = false
            }
        }
    }

    val (numbers1, operands1) = doCalculations(numbers, operands, "times")
    val (numbers2, _) = doCalculations(numbers1, operands1, "plus")

    return numbers2.first
}

fun doCalculations(numbers: LinkedList<Int>, operands: LinkedList<String>, type: String): Pair<LinkedList<Int>, LinkedList<String>> {
    // Go through the operands and find all indices that have a 'multiply', and multiply the requisite 2 numbers in the numbers list
    var nextIndex = operands.indexOfFirst { it == type }
    while (nextIndex != -1) {
        val firstNum = numbers.removeAt(nextIndex)
        val secondNum = numbers.removeAt(nextIndex)
        val result = operate(firstNum, secondNum, type)
        numbers.add(nextIndex, result)
        operands.removeAt(nextIndex)
        nextIndex = operands.indexOfFirst { it == type }
    }

    return Pair(numbers, operands)
}

fun operate(firstNum: Int, secondNum: Int, type: String): Int {
    return when (type) {
        "plus" -> firstNum + secondNum
        "times" -> firstNum * secondNum
        else -> error("Couldn't handle type: $type")
    }
}

fun main(args: Array<String>) {
    println(wordCalculator("one plus three times four"))
    println(wordCalculator("one plus negative three times four"))
    println(wordCalculator("one times three plus three times four plus five"))
    println(wordCalculatorPreProcessor("(one plus three) times 4"))
    println(wordCalculatorPreProcessor("(three times two plus (one plus four times five) times eight) times 9 plus 7"))
}