package com.pancake.brainburst.ui.screens.savedQuestions.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import com.pancake.brainburst.R
import com.pancake.brainburst.domain.model.FavoriteQuestionModel
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space80


@Composable
fun ItemSaveQuestionCard(
    question: FavoriteQuestionModel,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(space80)
            .clip(RoundedCornerShape(space16))
            .background(LightWhite500)
            .clickable(onClick = onClick)
            .padding(space16),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(.88f),
            text = question.question,
            style = Type.Title,
            color = Brand500,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.favorite_star),
            contentDescription = "save icon"
        )
    }

}
