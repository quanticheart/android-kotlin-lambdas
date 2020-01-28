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
 *  * Copyright(c) Developed by John Alves at 2020/1/27 at 0:37:33 for quantic heart studios
 *
 */

package com.quanticheart.kotlinlambdas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class InlineFunctions : AppCompatActivity() {

    /**
     * https://medium.com/@agrawalsuneet/inline-function-kotlin-3f05d2ea1b59
     * https://www.baeldung.com/kotlin-inline-functions
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Ao usar lambdas, as alocações extras de memória e a chamada extra de método virtual
     * introduzem alguma sobrecarga de tempo de execução. Portanto, se estivéssemos executando
     * o mesmo código diretamente, em vez de usar lambdas, nossa implementação seria mais eficiente.
     */

    /**
     * Temos que escolher entre abstração e eficiência?
     *
     * Como se vê, com as funções embutidas no Kotlin, podemos ter os dois!
     * Podemos escrever nossas lambdas agradáveis ​​e elegantes, e o compilador gera o
     * código embutido e direto para nós. Tudo o que precisamos fazer é colocar em linha:
     */

    inline fun <T> Collection<T>.each(block: (T) -> Unit) {
        for (e in this) block(e)
    }

    /**
     * Por padrão, todas as lambdas passadas para uma função embutida também seriam embutidas.
     * No entanto, podemos marcar algumas das lambdas com a  palavra-chave noinline para excluí-las da inclusão:
     */
    inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {
    }

    /**
     * Como vimos anteriormente, o Kotlin apaga as informações genéricas do tipo em tempo de
     * execução, mas, para funções em linha, podemos evitar essa limitação. Ou seja,
     * o compilador pode reificar informações de tipo genérico para funções embutidas.

    Tudo o que precisamos fazer é marcar o parâmetro type com a palavra-chave reified:
     */
    inline fun <reified T> Any.isA(): Boolean = this is T
}
