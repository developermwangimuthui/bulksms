package com.intelligentsoftwares.bulksms.roomPersistence.converters

import androidx.room.TypeConverter
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.list
import com.intelligentsoftwares.bulksms.activities.sendBulkSms.data.SmsContact

/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */
@UnstableDefault
object CollectionTypeConverter {

    @TypeConverter
    @JvmStatic
    fun toCollectionString(list: List<SmsContact>): String {
        return Json.stringify(SmsContact.serializer().list, list)
    }

    @TypeConverter
    @JvmStatic
    fun fromStringToCollection(json: String): List<SmsContact> {
        return Json.parse(SmsContact.serializer().list, json)
    }
}