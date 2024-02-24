import kotlin.math.abs
import kotlin.math.min

fun main(args: Array<String>) {
    println(multiply("82978","75"))
}

fun countAndSay(n: Int): String {
    if (n == 1)
        return "" + 1;
    val str = countnums(countAndSay(n-1) + " ");
    return str;
}
fun countnums( n:String): String {

    var cur = n[0];
    var counter = 0;
    var str = "";
    for (i in n.indices) {
        if (n[i] == cur)
            counter++;
        else {
            str += "" + counter + cur;
            cur = n[i];
            counter = 1;
        }
    }
    return str;
}
fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0")
        return "0";
    if (num1 == "1")
        return num2;
    if (num2 == "1")
        return num1
    var smaller = if (num1.length <= num2.length) num1 else num2;
    var larger = if (num1 == smaller) num2 else num1;

    var spaces = "";
    for (i in 0..<abs(larger.length - smaller.length)) {
        spaces += "0";
    }
    smaller = spaces + smaller;
    var answ = "";
    for (j in 0..<smaller.length) {
        val i = smaller.length - 1 - j;
        var first = "";
        var rem = 0;
        for (p in 0..<larger.length) {
            val k = larger.length - 1 - p;
            first += ((smaller[i].digitToInt() * larger[k].digitToInt()) + rem) % 10;
            rem = (smaller[i].digitToInt() * larger[k].digitToInt() + rem) / 10;
            println("first " + first)
            println("rem " + rem)

        }
        if (rem != 0)
            first += rem
        first = first.reversed()
        if (first != "0") {
            for (n in 0..<j) {
                first += "0";
            }
        }
        println("first now : $first")
        answ  = addStrings(answ, first)

        println("answ $answ")
    }
    var xd = answ;
    for (i in xd.indices) {
        if (xd[i] == '0')
            answ =  xd.substring(i+1)
        else break;
    }
    return answ;
}



fun addStrings(num1: String, num2: String): String {
    var smaller = if (num1.length <= num2.length) num1 else num2;
    var larger = if (num1 == smaller) num2 else num1;

    var spaces = "";
    for (i in 0..<abs(larger.length - smaller.length)) {
        spaces += "0";
    }
    smaller = spaces + smaller;
    var answ = "";
    var rem = 0;
    for (j in 0..<smaller.length) {
        val i = smaller.length - 1 - j;
            answ += (smaller[i].digitToInt() + larger[i].digitToInt() + rem) % 10;
            rem = (smaller[i].digitToInt() + larger[i].digitToInt() + rem) / 10;


        if (i == 0 && rem != 0)
            answ += rem;
    }
    return answ.reversed()
}
