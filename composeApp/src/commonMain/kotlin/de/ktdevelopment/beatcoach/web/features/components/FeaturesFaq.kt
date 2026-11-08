package de.ktdevelopment.beatcoach.web.features.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__1__a
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__1__q
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__2__a
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__2__q
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__3__a
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__3__q
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__4__a
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__4__q
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__5__a
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__5__q
import beatcoachwebsite.composeapp.generated.resources.pages__features__faq__title
import de.ktdevelopment.beatcoach.web.features.model.FaqItem
import org.jetbrains.compose.resources.stringResource

@Composable
fun FeaturesFaq(modifier: Modifier = Modifier) {
    val items = listOf(
        FaqItem(Res.string.pages__features__faq__1__q, Res.string.pages__features__faq__1__a),
        FaqItem(Res.string.pages__features__faq__2__q, Res.string.pages__features__faq__2__a),
        FaqItem(Res.string.pages__features__faq__3__q, Res.string.pages__features__faq__3__a),
        FaqItem(Res.string.pages__features__faq__4__q, Res.string.pages__features__faq__4__a),
        FaqItem(Res.string.pages__features__faq__5__q, Res.string.pages__features__faq__5__a),
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(Res.string.pages__features__faq__title),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items.forEach { item ->
                FaqCard(item = item)
            }
        }
    }
}

@Composable
private fun FaqCard(item: FaqItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        ),
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
            Text(
                text = stringResource(item.question),
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(item.answer),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
