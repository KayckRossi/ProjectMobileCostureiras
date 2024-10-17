package com.example.costureiraprojectcs

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class homeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Configura o ajuste de margens do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura os ouvintes de clique para os botões
        findViewById<AppCompatButton>(R.id.btnCadastrarPedido).setOnClickListener {
            val intent = Intent(this, pedidoActivity::class.java)
            startActivity(intent)
        }

//        findViewById<AppCompatButton>(R.id.btnManutencaoPedido).setOnClickListener {
//            val intent = Intent(this, ManutencaoPedidoActivity::class.java)
//            startActivity(intent)
//        }

//        findViewById<AppCompatButton>(R.id.btnDeletarPedido).setOnClickListener {
//            val intent = Intent(this, DeletarPedidoActivity::class.java)
//            startActivity(intent)
//        }

//        findViewById<AppCompatButton>(R.id.btnDetalhesPedido).setOnClickListener {
//            val intent = Intent(this, DetalhesPedidoActivity::class.java)
//            startActivity(intent)
//        }

//        findViewById<AppCompatButton>(R.id.btnContato).setOnClickListener {
//            val intent = Intent(this, ContatoActivity::class.java)
//            startActivity(intent)
//        }

        findViewById<AppCompatButton>(R.id.btnCadastrarUsuario).setOnClickListener {
            val intent = Intent(this, registrarActivity::class.java)
            startActivity(intent)
        }
    }
}