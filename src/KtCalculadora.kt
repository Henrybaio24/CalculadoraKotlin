import javax.swing.JFrame

var total: Double = 0.0
var numStr: String = ""
var num: Double = 0.0
var signo: Char = 'I'

fun main(args: Array<String>){
    Calculadora().defaultCloseOperation = JFrame.EXIT_ON_CLOSE
}
fun mostrar(i: Byte): String{
    numStr += i
    return numStr
}

fun calcular(c: Char): String{
    if (c == 'C'){
        signo = 'I'
        num = 0.0
        total = 0.0
        numStr = ""
    }else{
        if (numStr.isNotEmpty()){
            num = java.lang.Double.parseDouble(numStr)
            numStr = ""
        }
        when(signo){
            'I' -> total = num
            '+' -> total += num
            '-' -> total -= num
            'X' -> total *= num
            '/' -> total /= num
        }
        signo = c
    }
    return "" + total
}