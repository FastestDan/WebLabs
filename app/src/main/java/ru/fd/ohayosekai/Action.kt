package ru.fd.ohayosekai

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.Date


@Entity
data class Action(
    @PrimaryKey(autoGenerate = true) val id: Int = -1,
    val type: String,
    val start: String,
    val finish: String,
//    val latlot: Pair<Float, Float>
    var latlot: Int
    )

