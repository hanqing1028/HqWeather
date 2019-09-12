package com.travlerrr.hqweather.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.travlerrr.hqweather.di.module.DrawerMoudle;
import com.travlerrr.hqweather.di.module.MainModule;
import com.travlerrr.hqweather.mvp.contract.DrawerContract;
import com.travlerrr.hqweather.mvp.contract.MainContract;
import com.travlerrr.hqweather.mvp.ui.activity.MainActivity;
import com.travlerrr.hqweather.mvp.ui.fragment.DrawerFragment;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/11/2019 20:01
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = DrawerMoudle.class, dependencies = AppComponent.class)
public interface DrawerComponent {
    void inject(DrawerFragment drawerFragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        DrawerComponent.Builder view(DrawerContract.View view);

        DrawerComponent.Builder appComponent(AppComponent appComponent);

        DrawerComponent build();
    }
}