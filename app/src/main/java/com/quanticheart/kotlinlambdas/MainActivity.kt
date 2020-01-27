package com.quanticheart.kotlinlambdas

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    /**
     * https://www.raywenderlich.com/2268700-introduction-to-kotlin-lambdas-getting-started
     */

    /**
     * A expressão lambda é uma representação simplificada de uma função.
     * Pode ser passado como parâmetro, armazenado em uma variável ou até retornado como um valor.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val t = conection("go", {

        }, {

        })

        val t2 = conection2("err", {

        }, {

        })

        verifyWindowManager {

        }

        verifyWindowManager({

        }, {

        })

        verifyWindowManager2 { windowManager, status ->

        }

    }

    fun Activity.verifyWindowManager(
        deuCerto: (WindowManager) -> Unit,
        deuErro: (() -> Unit)? = null
    ) {
        if (this.windowManager.defaultDisplay.isValid) deuCerto.invoke(this.windowManager) else deuErro?.let { it() }
    }

    private fun Activity?.verifyWindowManager(
        deuCerto: (WindowManager?) -> Unit
    ) {
        if (this?.windowManager?.defaultDisplay?.isValid == true
        ) deuCerto.invoke(this.windowManager)
    }

    private fun Activity?.verifyWindowManager2(
        deuCerto: (WindowManager?, status: Boolean) -> Unit
    ) {
        if (this?.windowManager?.defaultDisplay?.isValid == true
        ) deuCerto.invoke(this.windowManager, true)
    }

    /**
     * Test lambda
     */
    private fun showAddSongDialog() {
        // 1
        val lambda1: () -> Unit = { println("Hello, world") }
        // 2
        val lambda2 = { println("Hello, world") }
        // 3
        lambda2()
    }

    /**
     * Você especifica expressões lambda nos seguintes formatos:
     */

    /**
     * lambda1 armazena um lambda que aceita um único parâmetro com o tipo Stringe não retorna nenhum valor.
     * lambda2 prova que você pode ignorar o tipo de parâmetro lambda, pois ele já foi especificado por meio do tipo de função variável.
     * lambda3 nome do parâmetro e →é ignorado e, em vez disso, a itpalavra-chave é usada. itpode ser usado para se referir ao parâmetro em lambdas com apenas um argumento.
     * lambda4 você usa a mesma estrutura que lambda3, mas, nesse caso, não utiliza o Stringparâmetro
     * lambda5 declaração de tipo da variável representa uma função com dois parâmetros do tipo Intcom tipo de retorno também como Int. Neste exemplo, você tem um código de bloco com várias instruções. A última instrução lambda x + yajuda o compilador a inferir o tipo de retorno do lambda.
     * lambda6 representa a forma simplificada de lambda5.
     */
    private fun test2() {
        // 1
        val lambda1: (String) -> Unit = { name: String -> println("Olá, $name ") }
        // 2
        val lambda2: (String) -> Unit = { name -> println("Hello , $name ") }
        // 3
        val lambda3: (String) -> Unit = { println(" Olá, $it ") }
        // 4
        val lambda4: (String) -> Unit = { println(" Olá, mundo!") }
        // 5
        val lambda5: (Int, Int) -> Int = { x, y ->
            print(x)
            print(y)
            x + y
        } // 6 val lambda6 = {x: Int , y: Int -> x + y}

        val lambda9: (String) -> Unit = { name: String -> 
            println("Olá, $name ")
        }

    }

    @Suppress("SameParameterValue")
    private fun conection(
        data1: String,
        deuCerto: ((Boolean) -> Unit),
        deuErro: ((Throwable) -> Unit)
    ) {
        if (data1 == "ok") deuCerto(true) else deuErro(Throwable("Err"))
    }

    @Suppress("SameParameterValue")
    private fun conection2(
        data1: String,
        deuCerto: ((Boolean) -> Unit),
        deuErro: ((Throwable) -> Unit)
    ): Boolean {
        return if (data1 == "ok") {
            deuCerto(true)
            true
        } else {
            deuErro(Throwable("Err"))
            false
        }
    }
}
