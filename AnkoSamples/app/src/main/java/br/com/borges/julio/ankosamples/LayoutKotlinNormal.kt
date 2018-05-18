package br.com.borges.julio.ankosamples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*

class LayoutKotlinNormal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val act = this
        val layout = LinearLayout(act)
        layout.orientation = LinearLayout.VERTICAL
        val txt = TextView(act)
        txt.text = "Digite o seu nome"

        val nome = EditText(act)

        val botao = Button(act)
        botao.text = "Clique aqui"

        botao.setOnClickListener {
            Toast.makeText(act, "Olá, ${nome.text}!", Toast.LENGTH_SHORT).show()
        }

        layout.addView(nome)
        layout.addView(botao)
    }
}