package com.example.schoolregistrationform.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolregistrationform.R
import com.example.schoolregistrationform.models.Course

class CoursesAdapter(var courseList: List<Course>):RecyclerView.Adapter<CoursesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.courses_resource_file,parent,false)
        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        val currentCourse=courseList.get(position)
        holder.date_created.text=currentCourse.date_created
        holder.date_updated.text=currentCourse.date_updated
        holder.created_by.text=currentCourse.created_by
        holder.updated_by.text=currentCourse.updated_by
        holder.active.text=currentCourse.active
        holder.course_id.text=currentCourse.course_id
        holder.course_name.text=currentCourse.course_name
        holder.course_code.text=currentCourse.course_code
        holder.description.text=currentCourse.description
        holder.instructor.text=currentCourse.instructor

    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}
class CoursesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var date_created=itemView.findViewById<TextView>(R.id.textView)
    var date_updated =itemView.findViewById<TextView>(R.id.textView2)
    var created_by= itemView.findViewById<TextView>(R.id.textView3)
    var updated_by=itemView.findViewById<TextView>(R.id.textView4)
    var active = itemView.findViewById<TextView>(R.id.textView5)
    var course_id = itemView.findViewById<TextView>(R.id.textView6)
    var course_name=itemView.findViewById<TextView>(R.id.textView7)
    var course_code=itemView.findViewById<TextView>(R.id.textView8)
    var description = itemView.findViewById<TextView>(R.id.textView9)
    var instructor = itemView.findViewById<TextView>(R.id.textView10)


}
