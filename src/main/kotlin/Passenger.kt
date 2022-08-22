import java.sql.DriverManager

data class Passenger(val p_id:Int, val p_name:String, val p_age:Int, val gender:String, val phone:String)

fun main(args:Array<String>) {
    val jdbcURL = "jdbc:mysql://localhost:3306/otbdb"
    val connection = DriverManager.getConnection(jdbcURL, "root", "Kashyap@2198")
    println(connection.isValid(0))

    // Insert Query
    //    val res = connection.createStatement()
//        .executeUpdate("insert into passengers(p_id,p_name,p_age,gender,phone) values (2,'Roger', 22, 'M', '9864567829')")
//    if (res > 0) {
//        println("New passenger added successfully")
//    } else {
//        println("Error")
//    }

//Update
//    val res_update=connection.createStatement().executeUpdate("update Passengers set passenger_name='Rohini',passenger_age=24,gender='F' where passenger_id=2")
//    if(res_update > 0){
//        println("Details updated")
//    }
//    else{
//        println("Updation not successful")
//    }

//Fetch
    val query = connection.prepareStatement("select *  from passengers")
    val result = query.executeQuery()
    val Passenger = mutableListOf<Passenger>()
    while (result.next()) {
        val p_id = result.getInt("passenger_id")
        val p_name = result.getString("passenger_name")
        val p_age = result.getInt("passenger_age")
        val gender = result.getString("gender")
        val phone = result.getString("phone")
        Passenger.add(Passenger(p_id,p_name,p_age,gender,phone))

    }
    println(Passenger)
}