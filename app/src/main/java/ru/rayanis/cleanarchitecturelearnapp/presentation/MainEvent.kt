package ru.rayanis.cleanarchitecturelearnapp.presentation

interface MainEvent

class SaveEvent(val text: String): MainEvent

class LoadEvent: MainEvent