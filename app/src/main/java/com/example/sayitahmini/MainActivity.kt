package com.example.sayitahmini

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var oyunBasladimi = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textViewSayiTahminEt: TextView = findViewById(R.id.textViewSayiTahminEt)
        var buttonOyunaBasla: Button = findViewById(R.id.buttonOyunaBasla)
        var imageViewDice: ImageView = findViewById(R.id.imageViewDice)
        //*****2. ekran*******
        var textViewKalanHak: TextView = findViewById(R.id.textViewKalanHak)
        var editTextSayiGirin: EditText = findViewById(R.id.editTextSayiGirin)
        var textViewArtirAzalt: TextView = findViewById(R.id.textViewArtirAzalt)
        var randomNumber = (1..5).random()
        var kalanHak = 5
        //*****KaybettinEkranı*********
        var textViewKaybettinKazandın:TextView = findViewById(R.id.textViewKaybettinKazandın)

        buttonOyunaBasla.setOnClickListener {
            if (oyunBasladimi) {
                randomNumber = (1..5).random()
                textViewKaybettinKazandın.visibility = View.INVISIBLE
                kalanHak = 5
                textViewKalanHak.text = "Kalan Hak ${kalanHak}"
                buttonOyunaBasla.text = "Oyuna Başla"
                textViewSayiTahminEt.visibility = View.INVISIBLE
                imageViewDice.visibility = View.INVISIBLE
                textViewKalanHak.visibility = View.VISIBLE
                editTextSayiGirin.visibility = View.VISIBLE
                buttonOyunaBasla.text = "Tahmin Et"
                oyunBasladimi = false
            }else{
                if (editTextSayiGirin.text.toString().toInt() == randomNumber){
                    textViewKaybettinKazandın.visibility = View.VISIBLE
                    textViewKaybettinKazandın.text = "Kazandın"
                    textViewKalanHak.visibility = View.INVISIBLE
                    editTextSayiGirin.visibility = View.INVISIBLE
                    textViewArtirAzalt.visibility = View.INVISIBLE
                    buttonOyunaBasla.text = "Tekrar Oyna"
                    oyunBasladimi = true
                }else{
                    if (editTextSayiGirin.text.toString().toInt() < randomNumber){
                        textViewArtirAzalt.text = "Artır"
                    }else{
                        textViewArtirAzalt.text = "Azalt"
                    }
                    kalanHak -= 1
                    textViewKalanHak.text = "Kalan Hak ${kalanHak}"
                    textViewArtirAzalt.visibility = View.VISIBLE
                    if (kalanHak == 0){
                        editTextSayiGirin.visibility = View.INVISIBLE
                        textViewArtirAzalt.visibility = View.INVISIBLE
                        textViewKalanHak.visibility = View.INVISIBLE
                        textViewKaybettinKazandın.visibility = View.VISIBLE
                        textViewKaybettinKazandın.text = "Kaybettin"
                        buttonOyunaBasla.text = "Tekrar dene"
                        oyunBasladimi = true
                    }
                }
            }
        }
    }
}