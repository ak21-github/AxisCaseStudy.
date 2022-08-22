import java.sql.DriverManager

data class Ticket(val tck_id:Int, val tck_number:Int,val p_id:Int,val t_id:Int, val tck_price:Int)

fun main() {
    val jdbcURL = "jdbc:mysql://localhost:3306/otbdb"
    val connection = DriverManager.getConnection(jdbcURL, "root", "Kashyap@2198")
    println(connection.isValid(0))

//Insert
    val res = connection.createStatement().executeUpdate("insert into Tickets(tck_id,tck_number,p_id,t_id,tck_price) values(1004,78765,1,1,1800)")
    if (res > 0) {
        println("Ticket added")
    } else {
        println("error")
    }

//Update Table
//    val res_update=connection.createStatement().executeUpdate("update Ticket set tck_price=2500 where tck_id=1004")
//    if(res_update > 0){
//        println("Successfully updated a record into db!!!")
//    }
//    else{
//        println("updation not successful")
//    }

// Delete
//    val delete_res = connection.createStatement().executeUpdate("delete from Tickets where Ttck_id=1004")
//    if (delete_res > 0) {
//        println("Successfully deleted a record from db!!!")
//    } else {
//        println("Deletion is not successful")
//    }

//--------- Display Tickets  -----------------
    val query = connection.prepareStatement("select *  from Ticket")
    val result = query.executeQuery()
    val Ticket = mutableListOf<Ticket>()
    while (result.next()) {
        val tck_id = result.getInt("Ticket_id")
        val tck_number = result.getInt("Ticket_number")
        val p_id = result.getInt("passenger_id")
        val t_id = result.getInt("Train_id")
        val tck_price = result.getInt("Ticket_price")
        Ticket.add(Ticket(tck_id,tck_number,p_id,t_id,tck_price))

    }
    println(Ticket)
}