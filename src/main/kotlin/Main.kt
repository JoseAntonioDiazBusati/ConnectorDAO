import DAO.UserDAOH2
import DB_CONNECTION.DataSourceFactory
import ENTITY.UserEntity
import OUTPUT.Console
import SERVICE.UserService

fun main() {

    val console = Console()

    // Creamos la instancia de la base de datos
    val dataSource = DataSourceFactory.getDS(DataSourceFactory.DataSourceType.HIKARI)

    // Creamos la instancia de UserDAO
    val userDao = UserDAOH2(dataSource, console)

    // Creamos la instancia de SERVICE. UserService
    val userService = UserService(userDao)

    // Creamos un nuevo usuario
    val newUser = UserEntity(name = "John Doe", email = "johndoe@example.com")
    var createdUser = userService.create(newUser)
    console.showMessage("Created user: $createdUser")

    // Obtenemos un usuario por su ID
    val foundUser = createdUser?.let { userService.getById(it.id) }
    console.showMessage("Found user: $foundUser")

    // Actualizamos el usuario
    val updatedUser = foundUser?.copy(name = "Jane Doe")
    val savedUser = updatedUser?.let { userService.update(it) }
    console.showMessage("Updated user: $savedUser")

    val otherUser = UserEntity(name = "Eduardo Fernandez", email = "eferoli@gmail.com")
    createdUser = userService.create( otherUser)
    console.showMessage("Created user: $createdUser")

    // Obtenemos todos los usuarios
    var allUsers = userService.getAll()
    if (allUsers != null) {
        console.show(allUsers)
    }

    // Eliminamos el usuario
    if (savedUser != null) {
        userService.delete(savedUser.id)
    }
    console.showMessage("User deleted")

    // Obtenemos todos los usuarios
    allUsers = userService.getAll()
    if (allUsers != null) {
        console.show(allUsers)
    }

    // Eliminamos el usuario
    userService.delete(otherUser.id)
    console.showMessage("User deleted")
}