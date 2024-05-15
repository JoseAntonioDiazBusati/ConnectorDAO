package OUTPUT

import ENTITY.UserEntity

interface IOutputInfo {
    fun showMessage(message: String, lineBreak: Boolean = true)

    fun show(userList: List<UserEntity>, message: String = "All users:")
}