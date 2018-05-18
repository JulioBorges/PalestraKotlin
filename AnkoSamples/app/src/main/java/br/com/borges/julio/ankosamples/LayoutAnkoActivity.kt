package br.com.borges.julio.ankosamples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class LayoutAnkoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            textView("Digite o seu nome")
            val nome = editText()
            button("Clique aqui") {
                onClick { toast("Olá, ${nome.text}!") }
            }
        }
    }

}