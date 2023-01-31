package com.example.appreceitas.viewmodel

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.lifecycle.ViewModel
import com.example.appreceitas.db.FakeDB
import com.example.appreceitas.model.Model
import com.example.appreceitas.model.ModelParent
import com.example.appreceitas.view.ui.FifthFragmentArgs

class FifthFragmentViewModel: ViewModel() {

    var statusUpdate = false

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

    fun isValidUpdate(
        view: View,
        args: FifthFragmentArgs,
        title: EditText,
        ingredients: EditText,
        prepMode: EditText,
        updateRadioGroup: RadioGroup,
        updateButton: Button
    ) {
        if (title.text.toString().isEmpty()) {
            title.setError("Este campo não pode ficar vazio.")
            !updateButton.isEnabled
        } else if (checkList(title)) {
            title.setError("Já existe uma receita com esse título.")
            !updateButton.isEnabled
        } else if (ingredients.text.toString().isEmpty()) {
            ingredients.setError("Este campo não pode ficar vazio.")
            !updateButton.isEnabled
        } else if (prepMode.text.toString().isEmpty()) {
            prepMode.setError("Este campo não pode ficar vazio.")
            !updateButton.isEnabled
        } else if (updateRadioGroup.checkedRadioButtonId == -1) {
            !updateButton.isEnabled
        } else {

            statusUpdate = true

            val radioButton =
                view.findViewById<RadioButton>(updateRadioGroup.checkedRadioButtonId)

            val updateRecipe = ModelParent(
                type = radioButton.text.toString(),
                recipeInfo = FakeDB.createRecipe(
                    Model(
                        title = title.text.toString(),
                        ingredients = ingredients.text.toString(),
                        prepMode = prepMode.text.toString()
                    )
                )
            )

            FakeDB.dbObject.find {
                it.recipeInfo[0].title == args.recipeUpdate.title
            }?.let {
                FakeDB.updateRecipe(it, updateRecipe)
            }
        }
    }
}