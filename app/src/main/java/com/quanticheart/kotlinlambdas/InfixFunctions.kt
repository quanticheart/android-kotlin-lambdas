/*
 *
 *  *                                     /@
 *  *                      __        __   /\/
 *  *                     /==\      /  \_/\/
 *  *                   /======\    \/\__ \__
 *  *                 /==/\  /\==\    /\_|__ \
 *  *              /==/    ||    \=\ / / / /_/
 *  *            /=/    /\ || /\   \=\/ /
 *  *         /===/   /   \||/   \   \===\
 *  *       /===/   /_________________ \===\
 *  *    /====/   / |                /  \====\
 *  *  /====/   /   |  _________    /      \===\
 *  *  /==/   /     | /   /  \ / / /         /===/
 *  * |===| /       |/   /____/ / /         /===/
 *  *  \==\             /\   / / /          /===/
 *  *  \===\__    \    /  \ / / /   /      /===/   ____                    __  _         __  __                __
 *  *    \==\ \    \\ /____/   /_\ //     /===/   / __ \__  ______  ____ _/ /_(_)____   / / / /__  ____ ______/ /_
 *  *    \===\ \   \\\\\\\/   ///////     /===/  / / / / / / / __ \/ __ `/ __/ / ___/  / /_/ / _ \/ __ `/ ___/ __/
 *  *      \==\/     \\\\/ / //////       /==/  / /_/ / /_/ / / / / /_/ / /_/ / /__   / __  /  __/ /_/ / /  / /_
 *  *      \==\     _ \\/ / /////        |==/   \___\_\__,_/_/ /_/\__,_/\__/_/\___/  /_/ /_/\___/\__,_/_/   \__/
 *  *        \==\  / \ / / ///          /===/
 *  *        \==\ /   / / /________/    /==/
 *  *          \==\  /               | /==/
 *  *          \=\  /________________|/=/
 *  *            \==\     _____     /==/
 *  *           / \===\   \   /   /===/
 *  *          / / /\===\  \_/  /===/
 *  *         / / /   \====\ /====/
 *  *        / / /      \===|===/
 *  *        |/_/         \===/
 *  *                       =
 *  *
 *  * Copyright(c) Developed by John Alves at 2020/1/27 at 0:21:37 for quantic heart studios
 *
 */

package com.quanticheart.kotlinlambdas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class InfixFunctions : AppCompatActivity() {

    /**
     * https://www.codigofonte.com.br/codigos/crie-funcoes-com-infix-notation-em-kotlin
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //without infix
        val i = 10.addMore(10)

        //With infix
        val ii = 10 addMore 10

        val exemplo = "Codigo" concat 10
        println(exemplo)

        val matches = "a bc def" substringMatches ".*? ".toRegex()

    }

    infix fun Int.addMore(value: Int): Int {
        return this.plus(value)
    }

    val exemplo = "Codigo" concat "Fonte"
    // Concatenação simples de strings
    infix fun String.concat(data: Int): String {
        return "$this $data"
    }

    infix fun String.concat(data: String): String {
        return "$this $data"
    }

    infix fun String.substringMatches(r: Regex) : List<String> {
        return r.findAll(this)
            .map { it.value }
            .toList()
    }

}
