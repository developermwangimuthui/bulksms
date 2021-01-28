package com.intelligentsoftwares.bulksms.roomPersistence

import androidx.room.TypeConverter
import java.util.*


/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */
class DateTypeConverter {

    @TypeConverter
    fun toDate(value: Long): Date? = Date(value)

    @TypeConverter
    fun fromDate(date: Date?): Long? = date?.time
}