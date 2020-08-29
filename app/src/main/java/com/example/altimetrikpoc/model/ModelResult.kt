package com.example.altimetrikpoc.model

import android.os.Parcel
import android.os.Parcelable
import com.example.altimetrikpoc.utils.DateHandler
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class ModelResult() : Parcelable {

    var artistName: String = ""
    var trackName: String = ""
    var collectionName: String = ""
    var collectionPrice = ""

    var releaseDate : Date = Date()

    var artworkUrl100: String = ""

    constructor(parcel: Parcel) : this() {
        artistName = parcel.readString().toString()
        trackName = parcel.readString().toString()
        collectionName = parcel.readString().toString()
        collectionPrice = parcel.readString().toString()
        artworkUrl100 = parcel.readString().toString()
    }
    override fun equals(o: Any?): Boolean {
        return o is ModelResult && (o.trackName == this.trackName)
    }
    override fun hashCode(): Int {
        return trackName.hashCode()
    }
    override fun describeContents(): Int {
        return 0
    }
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(artistName)
        dest?.writeString(trackName)
        dest?.writeString(collectionName)
        dest?.writeString(collectionPrice)
        dest?.writeString(artworkUrl100)
    }

    companion object CREATOR : Parcelable.Creator<ModelResult> {
        override fun createFromParcel(parcel: Parcel): ModelResult {
            return ModelResult(parcel)
        }

        override fun newArray(size: Int): Array<ModelResult?> {
            return arrayOfNulls(size)
        }
    }
}