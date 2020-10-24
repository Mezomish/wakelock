// Autogenerated from Pigeon (v0.1.14), do not edit directly.
// See also: https://pub.dev/packages/pigeon
package creativemaybeno.wakelock

import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.StandardMessageCodec
import java.util.ArrayList
import java.util.HashMap

/** Generated class from Pigeon.  */
object Messages {
    private fun wrapError(exception: Exception): HashMap {
        val errorMap: HashMap<String, Object> = HashMap()
        errorMap.put("message", exception.toString())
        errorMap.put("code", exception.getClass().getSimpleName())
        errorMap.put("details", null)
        return errorMap
    }

    /** Generated class from Pigeon that represents data sent in messages.  */
    class ToggleMessage {
        private var enable: Boolean? = null
        fun getEnable(): Boolean? {
            return enable
        }

        fun setEnable(setterArg: Boolean?) {
            enable = setterArg
        }

        fun toMap(): HashMap {
            val toMapResult: HashMap<String, Object> = HashMap()
            toMapResult.put("enable", enable)
            return toMapResult
        }

        companion object {
            fun fromMap(map: HashMap): ToggleMessage {
                val fromMapResult = ToggleMessage()
                val enable: Object = map.get("enable")
                fromMapResult.enable = enable
                return fromMapResult
            }
        }
    }

    /** Generated class from Pigeon that represents data sent in messages.  */
    class IsEnabledMessage {
        private var enabled: Boolean? = null
        fun getEnabled(): Boolean? {
            return enabled
        }

        fun setEnabled(setterArg: Boolean?) {
            enabled = setterArg
        }

        fun toMap(): HashMap {
            val toMapResult: HashMap<String, Object> = HashMap()
            toMapResult.put("enabled", enabled)
            return toMapResult
        }

        companion object {
            fun fromMap(map: HashMap): IsEnabledMessage {
                val fromMapResult = IsEnabledMessage()
                val enabled: Object = map.get("enabled")
                fromMapResult.enabled = enabled
                return fromMapResult
            }
        }
    }

    /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
    interface WakelockApi {
        fun toggle(arg: ToggleMessage?)
        val isEnabled: IsEnabledMessage

        companion object {
            /** Sets up an instance of `WakelockApi` to handle messages through the `binaryMessenger`  */
            fun setup(binaryMessenger: BinaryMessenger?, api: WakelockApi?) {
                run {
                    val channel: BasicMessageChannel<Object> = BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WakelockApi.toggle", StandardMessageCodec())
                    if (api != null) {
                        channel.setMessageHandler { message, reply ->
                            val wrapped: HashMap<String, HashMap> = HashMap()
                            try {
                                @SuppressWarnings("ConstantConditions") val input = ToggleMessage.fromMap(message as HashMap)
                                api.toggle(input)
                                wrapped.put("result", null)
                            } catch (exception: Exception) {
                                wrapped.put("error", wrapError(exception))
                            }
                            reply.reply(wrapped)
                        }
                    } else {
                        channel.setMessageHandler(null)
                    }
                }
                run {
                    val channel: BasicMessageChannel<Object> = BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WakelockApi.isEnabled", StandardMessageCodec())
                    if (api != null) {
                        channel.setMessageHandler { message, reply ->
                            val wrapped: HashMap<String, HashMap> = HashMap()
                            try {
                                val output = api.isEnabled
                                wrapped.put("result", output.toMap())
                            } catch (exception: Exception) {
                                wrapped.put("error", wrapError(exception))
                            }
                            reply.reply(wrapped)
                        }
                    } else {
                        channel.setMessageHandler(null)
                    }
                }
            }
        }
    }
}
