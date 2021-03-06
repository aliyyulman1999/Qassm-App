package org.d3if4070.qassmapp.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import org.d3if4070.qassmapp.MainActivity
import org.d3if4070.qassmapp.R

class QassmWidgetProvider : AppWidgetProvider() {

    companion object {
        private fun updateAppWidget(context: Context,
                                    manager: AppWidgetManager, id: Int) {
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(
                context, 0, intent, 0)
            val views = RemoteViews(context.packageName, R.layout.widget_main)
            views.setOnClickPendingIntent(R.id.iv_qassm, pendingIntent)
            manager.updateAppWidget(id, views)
        }
    }
    override fun onUpdate(context: Context?, manager: AppWidgetManager?,
                          ids: IntArray?) {
        if (context == null || manager == null || ids == null) return
        for (id in ids) {
            updateAppWidget(context, manager, id)
        }
    }
}