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
 *  * Copyright(c) Developed by John Alves at 2020/1/26 at 11:58:8 for quantic heart studios
 *
 */

package com.quanticheart.kotlinlambdas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class InvokeFunctions : AppCompatActivity() {

    /**
     * https://dzone.com/articles/learning-kotlin-invoke
     */

    /**
     * Hoje, lidamos com um operador estranho invoke, que permite que uma instância de uma classe
     * tenha uma função padrão que não tenho certeza de ter visto alguma linguagem. Então,
     * vamos explorar isso com um exemplo simples. Temos uma classe de configuração que retorna
     * a configuração para algo assim:
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val config = ConfigDefault()
        println(config.get())

        val config2 = ConfigDefault2()
        println(config2())

        val config3 = ConfigDefault3()
        config3()()()()()()()()()()()()()()().invoke()()
        println("config was called ${config3.count} times")

        val config4 = ConfigDefault4()
        config4("U")("l")("t")("i")("m")("a")("t")("e")
        println(config4.word)
    }

    /**
     * Default
     */

    /**
     * Hoje, lidamos com um operador estranho invoke, que permite que uma instância de uma
     * classe tenha uma função padrão que não tenho certeza de ter visto alguma linguagem. Então,
     * vamos explorar isso com um exemplo simples. Temos uma classe de configuração que retorna
     * a configuração para algo assim:
     */
    class ConfigDefault {
        fun get(): String {
            // Fazer coisas
            return "coisas"
        }
    }

    /**
     * Default with invoke
     */

    /**
     * Agora, em nosso mundo, talvez getseja o uso principal, para que possamos fazer com que a
     * instância de configuração possa ser chamada para obtê-lo:
     */
    class ConfigDefault2 {
        operator fun invoke(): String {
            return this.get()
        }

        private fun get(): String {
            // Fazer coisas
            return "coisas"
        }
    }

    /**
     * Constructor with Invoke
     */

    /**
     * Agora, você pode estar pensando: "legal, mas e daí - salvar algumas teclas não é demais".
     * Bem, invocar pode retornar qualquer coisa, inclusive a própria, que abre algo louco!
     */
    class ConfigDefault3 {
        var count = 0
        operator fun invoke(): ConfigDefault3 {
            count++
            return this
        }
    }

    /**
     * Contructor with Parans
     */

    /**
     * então vamos aumentar outro nível e passar parâmetros para invoke:
     */
    class ConfigDefault4 {
        var word = ""
        operator fun invoke(s: String): ConfigDefault4 {
            word += s
            return this
        }
    }

    /**
     * Constructor invoke object
     */
    class Data(val value: Int) {
        companion object {
            const val DEFAULT =-1
            //           v--- factory method
            operator fun invoke(value: String): Data = Data(value.toInt())

            //           v--- overloading invoke operator
            operator fun invoke(): Data = Data(DEFAULT)
        }
    }
}
