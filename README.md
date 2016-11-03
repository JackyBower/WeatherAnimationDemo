# WeatherAnimationDemo


模仿墨迹下雪效果

![](https://github.com/KitTak/WeatherAnimationDemo/blob/master/snowdemo/snow_demo.gif)

* 在布局中直接通过自定义 SurfaceView 来绘制提高效率

		<?xml version="1.0" encoding="utf-8"?>
		<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
				xmlns:tools="http://schemas.android.com/tools"
				android:id="@+id/activity_main"
				android:layout_width="match_parent"
				android:layout_height="match_parent">

				<com.kit.weather.animation.view.SceneSurfaceView
						android:id="@+id/sceneSurfaceView"
						android:layout_width="match_parent"
						android:layout_height="match_parent" />

		</RelativeLayout>
	
* 通过配置文件来控制雪花降落速度、及位置

		<?xml version="1.0" encoding="UTF-8"?>
			<weatherscene>
					<weather weather_bg="bg_snow_day" weather_blur="blur_bg_snow_day" weather_id="21">
							<actor angle="15" common_layer="0" common_rotatePosX="0.156" common_rotatePosY="0.352"
									common_scale="0.6" common_speed="70" common_type="snowFall" count="5" scaleX="2.0"
									scaleY="3.0">
									<name actor_name="snowflake_m" />
							</actor>
							<actor angle="15" common_layer="2" common_rotatePosX="0.156" common_rotatePosY="0.352"
									common_scale="0.85" common_speed="160" common_type="snowFall" count="5" endX="1.0"
									endY="1.0" scaleX="2.0" scaleY="3.0">
									<name actor_name="snowflake_l" />
							</actor>
							<actor angle="15" common_layer="1" common_rotatePosX="0.156" common_rotatePosY="0.352"
									common_scale="0.8" common_speed="380" common_type="snowFall" count="5" scaleX="2.0"
									scaleY="3.0">
									<name actor_name="snowflake_xl" />
							</actor>
							<actor angle="15" common_layer="0" common_rotatePosX="0.156" common_rotatePosY="0.352"
									common_scale="0.85" common_speed="700" common_type="snowFall" count="5" scaleX="2.0"
									scaleY="3.0">
									<name actor_name="snowflake_xxl" />
							</actor>
					</weather>
		</weatherscene>
