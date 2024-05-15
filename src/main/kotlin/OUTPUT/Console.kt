package OUTPUT

import ENTITY.UserEntity

class Console: IOutputInfo {
    override fun showMessage(message: String, lineBreak: Boolean) {
        if (lineBreak) {
            println(message)
        } else {
            print(message)
        }
    }

    override fun show(userList: List<UserEntity>, message: String) {
        if (userList.isEmpty()) {
            showMessage("No users found!")
        } else {
            showMessage(message)
            userList.forEachIndexed { index, user ->
                showMessage("\t${index + 1}. $user")
            }
        }
    }
}