package org.wit.hillfort.activities.hillfortList


import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.wit.hillfort.activities.HillfortMapsActivity
import org.wit.hillfort.activities.hillfort.HillfortView


import org.wit.hillfort.main.MainApp
import org.wit.hillfort.models.HillfortModel

class HillfortListPresenter (val view: HillfortListView) {

    var app: MainApp

    init {
        app = view.application as MainApp
    }

    fun getHillforts() = app.hillforts.findAll()

    fun doAddHillfort() {
        view.startActivityForResult<HillfortView>(0)
    }

    fun doEditHillfort(hillfort: HillfortModel) {
        view.startActivityForResult(view.intentFor<HillfortView>().putExtra("placemark_edit", hillfort), 0)
    }

    fun doShowHillfortsMap() {
        view.startActivity<HillfortMapsActivity>()
    }

}

