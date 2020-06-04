package es.sarascript.examenandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializamos Retrofit y lo conectamos con la interfaz
        val resourceService = ApiUtils.generateRetrofitInstance()
            .create(ResourceService::class.java)

        // Realizamos la petición y pintamos la lista

        CoroutineScope(Dispatchers.IO).launch {
            val response = resourceService.requestResourceList()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        val items = ItemMapper().transform(response.body()!!)

                        // Asignamos el layoutManager (Linear o Grid) al RecyclerView
                        mainList.layoutManager = LinearLayoutManager(this@MainActivity)

                        // Asignamos el adapter al RecyclerView
                        mainList.adapter = ItemAdapter(items, { Toast.makeText(this@MainActivity, it.name, Toast.LENGTH_SHORT).show() })

                    } else {
                        Log.e("error","Error: ${response.code()}")
                    }
                } catch (e: HttpException) {
                    Log.e("error","Exception ${e.message}")
                } catch (e: Throwable) {
                    Log.e("error","Ooops: Something else went wrong")
                }
            }
        }

        fun goToComments(view: View, name: String) {
            val intent = Intent(this, CommentsActivity::class.java).apply {
                putExtra("name", name)
            }
            startActivity(intent)
        }

    }
}