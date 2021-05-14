package com.example.todolist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.model.Todo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.generateqr.*

class MainActivity : AppCompatActivity() {

    private val todos:ArrayList<Todo> = ArrayList()
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvtodos.layoutManager=LinearLayoutManager(this)

        todos.add(Todo("First task",false))
        val todoAdapter= TodoAdapter(todos)
        rvtodos.adapter=todoAdapter

            button.setOnClickListener {
                val newTodo= add.text.toString()
                if(newTodo.isEmpty()){
                                 Toast.makeText(this,"Please enter a task",Toast.LENGTH_SHORT).show()

                }
                else {
                    todos.add(Todo(newTodo, false))
                    todoAdapter.notifyDataSetChanged()
                }

                imageqr.setOnClickListener{
                    val intent=Intent(this@MainActivity,generateqr::class.java)
                    intent.putExtra("TodoDetail",newTodo)
                    startActivity(intent);
                }
            }


            }
    }
