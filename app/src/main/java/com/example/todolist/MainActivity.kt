package com.example.todolist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.model.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val todos:ArrayList<Todo> = ArrayList()
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
            }
            }
    }
