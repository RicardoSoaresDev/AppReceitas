package com.example.appreceitas.viewmodel

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.appreceitas.db.FakeDB
import com.example.appreceitas.model.Model
import com.example.appreceitas.model.ModelParent

class SecondFragmentViewModel : ViewModel() {

    var statusCreate = false

    private fun checkList(title: EditText): Boolean {
        var status = false
        FakeDB.dbObject.forEach { modelParent ->
            modelParent.recipeInfo.forEach { model ->
                if (model.title == title.text.toString()) {
                    status = true
                }
            }
        }
        return status
    }


    fun isValidInput(
        view: View,
        name: EditText,
        ingredients: EditText,
        preparationMode: EditText,
        radioGroup: RadioGroup,
        button3: Button
    ) {

        if (name.text.toString().isEmpty()) {
            name.setError("Este campo não pode ficar vazio.")
            !button3.isEnabled
        } else if (checkList(name)) {
            name.setError("Já existe uma receita com esse título.")
            !button3.isEnabled
        } else if (ingredients.text.toString().isEmpty()) {
            ingredients.setError("Este campo não pode ficar vazio.")
            !button3.isEnabled
        } else if (preparationMode.text.toString().isEmpty()) {
            preparationMode.setError("Este campo não pode ficar vazio.")
            !button3.isEnabled
        } else if (radioGroup.checkedRadioButtonId == -1) {
            !button3.isEnabled
        } else {

            statusCreate = true

            // pass view in the function constructor
            val radioButton = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

            FakeDB.addRecipe(
                ModelParent(
                    type = radioButton.text.toString(),
                    recipeInfo = FakeDB.createRecipe(
                        Model(
                            title = name.text.toString(),
                            ingredients = ingredients.text.toString(),
                            prepMode = preparationMode.text.toString()
                        )
                    )
                )
            )
        }
    }
}