package com.pancake.brainburst.ui.screens.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.home.composable.IconButtonSmall
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.lightBackgroundColor
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space4

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    @StringRes idTitleStringRes: Int,
    onClickBack: (() -> Unit)?,

) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        if (onClickBack != null)
            IconButtonSmall(
                onClick = onClickBack,
                iconColor = MaterialTheme.colorScheme.onBackground,
                background = lightBackgroundColor,
                imageVector = Icons.Rounded.ArrowBack,
            )

        Spacer(modifier = Modifier.size(space16))
        Text(
            modifier = Modifier.padding(vertical = space4),
            text = stringResource(id = idTitleStringRes),
            style = Type.Title,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    AppBar(
        idTitleStringRes = R.string.saved_questions
    ) {}
}