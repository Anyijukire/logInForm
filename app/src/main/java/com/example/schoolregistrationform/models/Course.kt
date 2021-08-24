package com.example.schoolregistrationform.models

data class Course(var date_created: String,
                  var date_updated : String,
                  var created_by: String,
                  var updated_by:String,
                  var active: String,
                  var course_id:String,
                  var course_name:String,
                  var course_code:String,
                  var description:String,
                  var instructor:String

                  )

//"date_created": "2021-07-14T14:58:11.469525+03:00",
//"date_updated": "2021-07-14T15:00:32.276558+03:00",
//"created_by": "e0d94341-53c9-49c5-909c-8bcae5873ac0",
//"updated_by": "e0d94341-53c9-49c5-909c-8bcae5873ac0",
//"active": true,
//"course_id": "37e39c62-bcd2-44c0-b835-c741254814c8",
//"course_name": "Mathematics",
//"course_code": "MAT 301",
//"description": "Mathematics for computing",
//"instructor": "Katerina M."