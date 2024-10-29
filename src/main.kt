import java.math.BigInteger

// Вячеслав Галинов
// Функция для проверки, является ли число простым
fun isPrime(n: Long): Boolean {
    return false
}

// Вячеслав Галинов
// Функция для нахождения случайного простого числа
fun generatePrime(min: Long, max: Long): Long {
    return 0
}

// Вячеслав Галинов
// Расширенный алгоритм Евклида для нахождения обратного по модулю числа
fun extendedGCD(a: Long, b: Long): Pair<Long, Long> {
    return Pair(0L, 0L)
}

// Вячеслав Галинов
// Функция для нахождения мультипликативной обратной по модулю
fun modInverse(e: Long, phi: Long): Long {
    return 0L
}

// Вячеслав Галинов
// Основная функция для генерации ключей RSA
fun generateRSAKeyPair(): Pair<Pair<Long, Long>, Pair<Long, Long>> {
    return Pair(Pair(0L, 0L), Pair(0L, 0L))
}

// Дмитрий Крымин
// Функция для шифрования одного символа с использованием RSA
fun rsaEncrypt(char: Char, publicKey: Pair<Long, Long>): Long {
    /*
    * Функция принимает 2 параметра:
    * 1. char - символ для шифрования.
    * 2. publicKey - публичный ключ шифрования.
    * Функция возвращает число.
    *
    * Функция зашифровывает символ строки и возвращает его.
    */
    val (e, n) = publicKey
    val bigE = BigInteger.valueOf(e)
    val bigN = BigInteger.valueOf(n)
    val charValue = BigInteger.valueOf(char.code.toLong())
    val encryptedChar = charValue.modPow(bigE, bigN)
    return encryptedChar.toLong()

}

// Дмитрий Крымин
// Функция для шифрования строки с использованием RSA
fun encryptStringWithRSAAndPunctuation(text: String, publicKey: Pair<Long, Long>): String {
    /*
    * Функция принимает 2 параметра:
    * 1. text - в функцию передается строка для шифрования
    * 2. publicKey - Публичный ключ шифрования
    * Функция возвращает зашифрованную полную строку.
    * Функция должна делать вызов зашифровки одного символа.
    *
    * Фунция шифрует каждый символ строки и разделяет их случайным символом припенания.
    */
    val punctuationMarks = listOf(',', '.', '!', '?', ':', ';', '-', '_')
    val encryptedText = StringBuilder()
    for (char in text) {
        val encryptedChar = rsaEncrypt(char, publicKey)
        encryptedText.append(encryptedChar)
        encryptedText.append(punctuationMarks.random())
    }
    return encryptedText.toString()
}

// Данила Лапшин
// Функция для расшифровки одного символа с использованием RSA
fun rsaDecrypt(encryptedChar: Long, privateKey: Pair<Long, Long>): Char {
    /*
    * Функция принимает 2 параметра:
    * 1. encryptedChar - символ для расшифровки.
    * 2. privateKey - приватный ключ шифрования.
    * Функция возвращает символ.
    *
    * Функция расшифровывает символ строки и возвращает его.
    */
    return 'a'
}

// Данила Лапшин
// Функция для расшифровки строки с учетом случайных знаков препинания
fun decryptStringWithRSAAndPunctuation(encryptedText: String, privateKey: Pair<Long, Long>): String {
    /*
    * Функция принимает 2 параметра:
    * 1. encryptedText - текст для расшифровки.
    * 2. privateKey - приватный ключ шифрования.
    * Функция возвращает полную расшифрованную строку.
    * Функция должна делать вызов расширофки одного символа.
    *
    * Функция расшифровывает полную строки.
    */
    return "a"
}


//Для всей группы:
fun main() {

    val helpInfo: String = "1. new_keys - создать новые ключи.\n" +
            "2. show_keys - показать текущие ключи.\n" +
            "3. encrypt - зашифровать сообщение.\n" +
            "4. decrypt - расшифровать сообщение.\n" +
            "5. exit - завершить работу программы.\n"

    var currentPairKeys: Pair<Pair<Long, Long>, Pair<Long, Long>> = generateRSAKeyPair()

    while (true) {
        println(
            "Введите команду.\n" +
                    "Посмотреть список доступных команд - help:\n"
        )

        var userInput: String = readlnOrNull().toString()
        when (userInput) {
            "new_keys" -> {
                currentPairKeys = generateRSAKeyPair()
            }

            "show_keys" -> {
                println("Public key: e = ${currentPairKeys.first.first}, n = ${currentPairKeys.first.second}")
                println("Private Key: d = ${currentPairKeys.second.first}, n = ${currentPairKeys.second.second}")
            }

            "encrypt" -> {
                println("Введите сообщение для шифрования:")
                val userInputTextToEncrypt = readlnOrNull().toString()
                val encryptedText = encryptStringWithRSAAndPunctuation(userInputTextToEncrypt, currentPairKeys.first)
                println("Зашифрованная строка: $encryptedText")
            }

            "decrypt" -> {
                println("Введите зашифровонное сообщение:")
                val userInputTextToDecrypt = readlnOrNull().toString()
                val decryptedText = decryptStringWithRSAAndPunctuation(userInputTextToDecrypt, currentPairKeys.second)
                println("Расшифрованная строка: $decryptedText")
            }

            "help" -> {
                println(helpInfo)
            }

            else -> {
                println("No such command found.")
            }
        }

    }
}
