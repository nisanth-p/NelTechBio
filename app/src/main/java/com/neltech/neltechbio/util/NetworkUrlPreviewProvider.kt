package com.neltech.neltechbio.util

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class NetworkUrlPreviewProvider() : PreviewParameterProvider<String> {
    override val values: Sequence<String>
        get() = sequenceOf("")
    override val count: Int
        get() = super.count
}