package uz.unical.core.utils

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.app.Activity
import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.location.LocationManager
import android.net.Uri
import android.os.SystemClock
import android.provider.OpenableColumns
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.appbar.AppBarLayout
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import uz.unical.core.BuildConfig
import uz.unical.core.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.math.abs


/**
 * Created by Temur on 16/03/22.
 */

val TextView.str: String
    get() = text.toString().trim()


val File.size get() = if (!exists()) 0.0 else length().toDouble()
suspend fun File.moveTo(target: File) = withContext(Dispatchers.IO) {
    if (!this@moveTo.renameTo(target))
        throw IOException()
}

fun Context.deleteById(bookId: String): Boolean {
    val file = File(filesDir, bookId)
    return file.delete()
}

fun Context.delete(path: String): Boolean {
    val file = File(path)
    return file.delete()
}

fun List<Double?>.getChildCount(): Double {
    var count = 0.0
    forEach {
        count += it ?: 0.0
    }
    return count
}


fun AppBarLayout.onStateChanged(onCollapse: () -> Unit = {}, onExpanded: () -> Unit = {}) {
    addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
        if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
            //  Collapsed
            onCollapse.invoke()

        } else {
            //Expanded
            onExpanded.invoke()
        }
    })
}

fun InputStream.toContent(
    context: Context,
    extension: String,
    fileName: String = "bookfile"
): File {
    use {
        val file =
            File(context.filesDir, if (fileName != extension) "$fileName.$extension" else fileName)
        FileOutputStream(file).use { output ->
            val buffer = ByteArray(4 * 1024)
            var read: Int
            while (read(buffer).also { read = it } != -1) {
                output.write(buffer, 0, read)
            }
            output.flush()
        }
        return file
    }
}

fun InputStream.toAudiosContent(
    context: Context,
    extension: String,
    fileName: String = "audio"
): File {
    use {
        val audioFile = File(context.filesDir, "audios")
        audioFile.mkdir()
        val file = File(audioFile, fileName)
        FileOutputStream(file).use { output ->
            val buffer = ByteArray(4 * 1024)
            var read: Int
            while (read(buffer).also { read = it } != -1) {
                output.write(buffer, 0, read)
            }
            output.flush()
        }
        return file
    }
}


fun InputStream.toDecryptedContent(
    context: Context,
    extension: String,
    fileName: String = "bookfile"
): File {
    use {
        val dir = File(context.filesDir, "decrypted")
        dir.mkdir()
        val file = File(dir, "$fileName.$extension")
        FileOutputStream(file).use { output ->
            val buffer = ByteArray(4 * 1024)
            var read: Int
            while (read(buffer).also { read = it } != -1) {
                output.write(buffer, 0, read)
            }
            output.flush()
        }
        return file
    }
}


fun InputStream.toAudiosDecrypted(
    context: Context,
    extension: String,
    fileName: String = "bookfile"
): File {
    use {
        val dir = File(context.filesDir, "audio_decrypted")
        dir.mkdir()
        val file = File(dir, "$fileName.$extension")
        FileOutputStream(file).use { output ->
            val buffer = ByteArray(4 * 1024)
            var read: Int
            while (read(buffer).also { read = it } != -1) {
                output.write(buffer, 0, read)
            }
            output.flush()
        }
        return file
    }
}

/**
The value that returned by isEdgeToEdgeEnabled function will follow below:

Navigation is displaying with 3 buttons

Navigation is displaying with 2 button(Android P navigation mode)

Full screen gesture(Gesture on android Q)
 */

fun Context.isEdgeToEdgeEnabled(): Int {
    val resourceId: Int =
        resources.getIdentifier("config_navBarInteractionMode", "integer", "android")
    return if (resourceId > 0) {
        resources.getInteger(resourceId)
    } else 0
}

fun Context.clearDecryptedBooks(action: (Boolean) -> Unit = {}) {
    try {
        val dir = File(filesDir, "decrypted")
        if (dir.isDirectory) {
            action.invoke(dir.deleteRecursively())
        }
    } catch (e: Throwable) {
    }
}

fun Context.clearDecryptedAudios(action: (Boolean) -> Unit = {}) {
    try {
        val dir = File(filesDir, "audio_decrypted")
        if (dir.isDirectory) {
            action.invoke(dir.deleteRecursively())
        }
    } catch (e: Throwable) {
    }
}

fun Context.clearCache(action: (Boolean) -> Unit = {}) {
    try {
        if (filesDir.isDirectory) {
            action.invoke(filesDir.deleteRecursively())
        }
    } catch (e: Throwable) {
    }
}

data class PlaceHolderItem(val width: Int)

fun View.generatePlaceHolderItems(): List<PlaceHolderItem> {
    val list = ArrayList<PlaceHolderItem>()

    for (i in 0 until 32) {
        val generatedNum = generateNumber().toFloat()
        list.add(PlaceHolderItem(dpInt(generatedNum)))
    }

    return list
}

fun generateNumber(): Int {
    val r = Random()
    val low = 120
    val high = 370
    return r.nextInt(high - low) + low
}

fun View.dpInt(value: Float): Int {
    val metrics = this.resources.displayMetrics
    return if (value == 0f) {
        0
    } else TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, metrics).toInt()
}


fun View.visibleIf(condition: Boolean) {
    visibility = if (condition) View.VISIBLE
    else View.GONE
}

fun <T> MutableLiveData<T>.asLiveData(): LiveData<T> {
    return this
}

fun <T1, T2, T3, T4, T5, T6, R> combineMix(
    flow: Flow<T1>,
    flow2: Flow<T2>,
    flow3: Flow<T3>,
    flow4: Flow<T4>,
    flow5: Flow<T5>,
    flow6: Flow<T6>,
    transform: suspend (T1, T2, T3, T4, T5, T6) -> R
): Flow<R> = combine(
    combine(flow, flow2, flow3, ::Triple),
    combine(flow4, flow5, flow6, ::Triple)
) { t1, t2 ->
    transform(
        t1.first,
        t1.second,
        t1.third,
        t2.first,
        t2.second,
        t2.third
    )
}

fun Fragment.toast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(@StringRes message: Int) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Context.toast(@StringRes message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ViewBinding.toast(@StringRes message: Int) {
    Toast.makeText(root.context, message, Toast.LENGTH_SHORT).show()
}


fun String.clearSpaces() = replace(" ", "")

inline fun scheduleAtFixedRate(crossinline action: () -> Unit, delay: Long, period: Long) {
    Timer().scheduleAtFixedRate(object : TimerTask() {
        override fun run() {
            action.invoke()
        }
    }, delay, period)
}

fun RecyclerView.setOnScrollListener(action: (isScrollDown: Boolean, dx: Int, dy: Int) -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (dy > 0) {
                action.invoke(false, dx, dy)
            } else {
                action.invoke(true, dx, dy)
            }
        }
    })
}

fun NestedScrollView.setOnScrollListener(action: (isScrollDown: Boolean, scrollX: Int, scrollY: Int) -> Unit) {
    setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
        if (scrollY > oldScrollY) action.invoke(true, scrollX, scrollY)
        else action.invoke(false, scrollX, scrollY)
    }
}

fun View.attachToRecyclerView(rv: RecyclerView) {
    rv.setOnScrollListener { isScrollDown, dx, dy ->
        if (isScrollDown) {
            animate().translationY(-500f).setDuration(200).start()
        } else {
            animate().translationY(0f).setDuration(200).start()
        }
    }
}

fun View.hideKeyboard() {
    val imm: InputMethodManager? =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.hideSoftInputFromWindow(windowToken, 0)
}

fun Context.dp(value: Float): Float {
    val metrics = this.resources.displayMetrics
    return if (value == 0f) {
        0f
    } else TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, metrics)
}

fun Context.shareText(string: String) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "text/plain"
    intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
    intent.putExtra(Intent.EXTRA_TEXT, string)


    startActivity(Intent.createChooser(intent, "Share using"))
}

fun <T : RecyclerView.ViewHolder> RecyclerView.Adapter<T>.notify() {
    notifyDataSetChanged()
}

fun ViewPager2.setAutoScroll(delay: Long, count: Int, scrollDuration: Long) {
    try {
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                var current = 0
                current = currentItem + 1
                if (current == count) current = 0
                setCurrentItem(current, if (current == 0) 0 else scrollDuration)
                delay(delay)
            }
        }
    } catch (e: Exception) {

    }
}

fun Context.isGpsEnabled(): Boolean {
    val manager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
    return manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
}


fun View.shake(duration: Long = 1000, isVertical: Boolean = false) {
    ObjectAnimator
        .ofFloat(
            this,
            "translation${if (isVertical) "Y" else "X"}",
            0f,
            25f,
            -25f,
            25f,
            -25f,
            15f,
            -15f,
            6f,
            -6f,
            0f
        )
        .setDuration(duration)
        .start()
}


private fun ViewPager2.setCurrentItem(
    item: Int,
    duration: Long,
    interpolator: TimeInterpolator = AccelerateDecelerateInterpolator(),
    pagePxWidth: Int = width
) {
    try {
        val pxToDrag: Int = pagePxWidth * (item - currentItem)
        val animator = ValueAnimator.ofInt(0, pxToDrag)
        var previousValue = 0
        animator.addUpdateListener { valueAnimator ->
            val currentValue = valueAnimator.animatedValue as Int
            val currentPxToDrag = (currentValue - previousValue).toFloat()
            fakeDragBy(-currentPxToDrag)
            previousValue = currentValue
        }
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                beginFakeDrag()
            }

            override fun onAnimationEnd(animation: Animator?) {
                endFakeDrag()
            }

            override fun onAnimationCancel(animation: Animator?) { /* Ignored */
            }

            override fun onAnimationRepeat(animation: Animator?) { /* Ignored */
            }
        })
        animator.interpolator = interpolator
        animator.duration = duration
        animator.start()
    } catch (e: Exception) {

    }
}

fun Context.makeRippleDrawable(
    @ColorInt rippleColor: Int = ContextCompat.getColor(this, R.color.black_alpha_25),
    @ColorInt backgroundColor: Int = ContextCompat.getColor(this, android.R.color.transparent),
    @ColorInt disabledColor: Int = backgroundColor,
    cornerRadius: Float = 5F,
    elevation: Float = 0F,
): Drawable {
    val outerRadii = FloatArray(8)
    Arrays.fill(outerRadii, dp(cornerRadius))

    val content: GradientDrawable?
    val mask: ShapeDrawable?

    if (backgroundColor == Color.TRANSPARENT) {
        content = null
        mask = ShapeDrawable(RoundRectShape(outerRadii, null, null))
        mask.colorFilter = PorterDuffColorFilter(rippleColor, PorterDuff.Mode.SRC_IN)
    } else {
        content = GradientDrawable().also {
            it.cornerRadii = outerRadii
            it.color = ColorStateList(
                arrayOf(
                    intArrayOf(android.R.attr.state_activated),
                    intArrayOf(android.R.attr.state_enabled),
                    intArrayOf(-android.R.attr.state_enabled)
                ),
                intArrayOf(
                    backgroundColor,
                    backgroundColor,
                    disabledColor
                )
            )
        }
        mask = null
    }

    return RippleDrawable(
        ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_pressed),
                intArrayOf(android.R.attr.state_focused),
                intArrayOf(android.R.attr.state_activated)
            ),
            intArrayOf(
                rippleColor,
                rippleColor,
                rippleColor
            )
        ),
        content,
        mask
    )
}


class SafeClickListener(
    private var defaultInterval: Int,
    private val onSafeCLick: (View) -> Unit
) : View.OnClickListener {
    private var lastTimeClicked: Long = 0
    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeCLick(v)
    }
}

fun View.singleClickListener(delay: Int = 1000, onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener(delay) {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}

fun Float.format(): String = String.format("%.2f", this)

fun Double.format(maxDigits: Int): String {
    val df = DecimalFormat()
    df.maximumFractionDigits = maxDigits
    var formatted = df.format(this).replace(",", ".")
    if (formatted.length == 1) {
        formatted = "$formatted.0"
    }

    return formatted
}

fun Double.formatDouble(maxDigits: Int): Double {
    val df = DecimalFormat()
    df.maximumFractionDigits = maxDigits
    return df.format(this).replace(",", ".").toDouble()
}

fun Long.parseToMM_SS(): String {
    val minutes = (this % 3600) / 60
    val seconds = this % 60

    val strMinutes = if (minutes < 10) "0$minutes" else minutes
    val strSeconds = if (seconds < 10) "0$seconds" else seconds

    return "$strMinutes:$strSeconds"
}

fun Long.toMS(): String {
    val minutes: Long = this / 1000 / 60
    val seconds = (this / 1000 % 60).toInt()
    val strMinutes = if (minutes < 10) "0$minutes" else minutes
    val strSeconds = if (seconds < 10) "0$seconds" else seconds

    return "$strMinutes:$strSeconds"
}

fun interface OnActionListener<T> {
    fun onAction(data: T)
}


fun ImageView.loadFromUrl(
    url: String?,
    @DrawableRes placeHolder: Int = R.drawable.test_avatar
) {
    if (url != null && this.context.isAvailable()) {
        Glide.with(this)
            .load("${BuildConfig.BASE_URL}$url")
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .placeholder(placeHolder)
            .into(this)
    }
}

fun Context?.isAvailable(): Boolean {
    if (this == null) {
        return false
    } else if (this !is Application) {
        if (this is FragmentActivity) {
            return !this.isDestroyed
        } else if (this is Activity) {
            return !this.isDestroyed
        }
    }
    return true
}

fun View.insetPadding(top: Boolean = false, bottom: Boolean = false) {
//    setPadding(
//        0,
//        if (top) context.getStatusBarHeight() else 0,
//        0,
//        if (bottom) context.getBottomBarHeight() else 0
//    )
}

fun String.nullIfEmpty() = if (this.trim() == "") null else this

fun Uri.toContent(context: Context): File? {
    val resolver = context.contentResolver

    val cursor = resolver.query(this, null, null, null, null)
    cursor?.moveToFirst()
    val index = (cursor?.getColumnIndex(OpenableColumns.DISPLAY_NAME)) ?: -1
    val name = cursor?.getString(index) ?: "CONTENT_NAME"
    cursor?.close()

    val file = File(context.filesDir, name)
    val out = FileOutputStream(file)
    val ins = resolver.openInputStream(this) ?: return null

    ins.copyTo(out)
    ins.close()
    out.close()

    return file
}

fun Context.copyText(text: String) {
    kotlin.runCatching {
        val clipboard: ClipboardManager? =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("label", text)
        clipboard?.setPrimaryClip(clip)
    }
    Toast.makeText(this, R.string.success_copy, Toast.LENGTH_SHORT).show()
}

fun Number?.moneyFormat(): String {
    val formatter: NumberFormat = DecimalFormat("#,###")
    return formatter.format(this ?: 0)
}


private var current = ""

fun AppCompatEditText.addFormatter() {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if (p0.toString() != current) {
                this@addFormatter.removeTextChangedListener(this);

                val cleanString = p0.toString().replace("[$,]", "");

                val parsed = cleanString.toDouble()
                val formatted = NumberFormat.getCurrencyInstance().format((parsed / 100));

                current = formatted;
                this@addFormatter.setText(formatted);
                this@addFormatter.setSelection(formatted.length)

                this@addFormatter.addTextChangedListener(this)
            }
        }

        override fun afterTextChanged(p0: Editable?) {

        }
    })
}

fun AppCompatEditText.clearRegex(): String {
    return this.text.toString().replace("$", "").replace(",", "").replace(".", "")
}