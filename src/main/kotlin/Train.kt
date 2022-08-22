import java.sql.DriverManager

data class Train(val t_id:Int, val t_no:Int,val t_name:String,val Source:String,val Destination:String,val departure_dt:String,val arrival_dt:String)

fun main() {
    val jdbcURL = "jdbc:mysql://localhost:3306/otbdb"
    val connection = DriverManager.getConnection(jdbcURL, "root", "Kashyap@2198")
    println(connection.isValid(0))
//Insert

//    val res = connection.createStatement().executeUpdate("insert into Train(Train_id,Train_no,Train_name,Source,Destination,Start_date_time,Arrival_time) values(104,89762,'Janashdabthi Express','Delhi','Ernakulam','08-08-2022 04:00 AM','10-08-2022 06:00PM')")
//     if (res > 0) {
//         println("New train detail inserted")
//     } else {
//         println("Error")
//     }

//Update

//    val res_update=connection.createStatement().executeUpdate("Update Train set Train_name='Kochuveli Express' where Train_id=104")
//    if(res_update > 0){
//        println("Train detail updated")
//    }
//    else{
//        println("error")
//    }

//Delete train

//    val delete_res=connection.createStatement().executeUpdate("delete from Train where Train_id=104")
//    if(delete_res > 0){
//        println("Train deleted")
//    }
//    else{
//        println("Deletion is not successful")
//    }


//Fetch

    val query = connection.prepareStatement("select *  from Train")
    val result = query.executeQuery()
    val Train = mutableListOf<Train>()
    while (result.next()) {
        val t_id = result.getInt("Train_id")
        val t_no = result.getInt("Train_no")
        val t_name = result.getString("Train_name")
        val Source = result.getString("Source")
        val Destination = result.getString("Destination")
        val departure_dt = result.getString("Start_date_time")
        val arrival_dt = result.getString("Arrival_time")
        Train.add(Train(t_id,t_no,t_name,Source,Destination,departure_dt,arrival_dt))

    }
    println(Train)
}