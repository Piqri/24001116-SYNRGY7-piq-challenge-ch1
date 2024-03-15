import java.util.*

fun main() {
    var continueProgram = true

    while (continueProgram) {
        print(
            """
            === Pilih Bentuk Yang Akan Ditampilkan ===
            1. Piramida bintang
            2. Piramida terbalik bintang
            3. Layang-layang bintang
            4. X Bintang
            5. Piramida hollow bintang
            6. Exit
            Masukkan pilihan Anda: 
            """.trimIndent()
        )

        when (readLine()?.toIntOrNull()) {
            1 -> drawStarPyramid()
            2 -> drawInvertedStarPyramid()
            3 ->drawDiamondStar()
            4 -> drawXStar()
            5 -> drawHollowStarPyramid()
            6 -> continueProgram = false
            else -> println("Pilihan tidak ada")
        }

        if (continueProgram) {
            continueProgram = askToContinue()
        }
    }

    println("Terima kasih telah menggunakan program.")
}

fun drawStarPyramid() {
    println("=== Piramida bintang ===")
    print("Masukkan jumlah baris: ")
    val rows = readLine()?.toIntOrNull() ?: return

    for (i in 1..rows) {
        print(" ".repeat(rows - i))
        println("* ".repeat(i))
    }
}

fun drawInvertedStarPyramid() {
    println("=== Piramida terbalik bintang ===")
    print("Masukkan jumlah baris: ")
    val rows = readLine()?.toIntOrNull() ?: return

    for (i in rows downTo 1) {
        print(" ".repeat(rows - i))
        println("* ".repeat(i))
    }
}

fun drawDiamondStar() {
    println("=== Layang-layang bintang ===")
    print("Masukkan jumlah baris: ")
    val rows = readLine()?.toIntOrNull() ?: return

    for (i in 1..rows) {
        print(" ".repeat(rows - i))
        println("* ".repeat(i))
    }
    for (i in rows - 1 downTo 1) {
        print(" ".repeat(rows - i))
        println("* ".repeat(i))
    }
}

fun drawXStar() {
    println("=== X Bintang ===")
    print("Masukkan jumlah baris: ")
    val rows = readLine()?.toIntOrNull() ?: return

    for (i in 1..rows) {
        for (j in 1..rows) {
            if (j == i || j == rows - i + 1) {
                print("*")
            } else {
                print(" ")
            }
        }
        println()
    }
}

fun drawHollowStarPyramid() {
    println("=== Piramida hollow bintang ===")
    print("Masukkan jumlah baris: ")
    val rows = readLine()?.toIntOrNull() ?: return

    for (i in 1..rows) {
        val spaces = " ".repeat(rows - i)
        if (i == 1 || i == rows) {
            println("$spaces* ".repeat(i))
        } else {
            val hollowSpaces = " ".repeat((i - 1) * 2 - 1)
            println("$spaces*${hollowSpaces}*")
        }
    }
}


fun askToContinue(): Boolean {
    print("Apakah Anda ingin melanjutkan program? (y/n): ")
    val answer = readLine()?.lowercase(Locale.getDefault())
    return answer == "y"
}
