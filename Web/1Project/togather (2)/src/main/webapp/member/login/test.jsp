<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>


<html ng-app="siteGeneratorStaticsConsumerApp" lang="ko">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Wix ADI</title>
  <meta name="description" content="Wix Artificial Design Intelligence Site Builder">
  <meta name="viewport" content="width=device-width">
  <meta name="robots" content="noindex, nofollow">
  <meta name="referrer" content="origin">

  <script type="text/javascript">
    window.consentPolicy = {"functional":true,"analytics":true,"advertising":true,"dataToThirdParty":true,"essential":true};
  </script>

  <!-- Google Tag Manager -->
  <script>
    if (window.consentPolicy.advertising) {
      (function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
      new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
      j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
      'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
      })(window,document,'script','dataLayer','GTM-MDD5C4');
    }
  </script>
  <!-- End Google Tag Manager -->

  <script type="text/javascript">
    console && console.log && console.log('ADI version 2.5376.0');
  </script>
  <script>
    var getMetadata = function() {
      return ;
    };

    function getUrlWithoutParameter(location) {
      var fixedUrl = location.href;
      var metaData = getMetadata();
      var storyId = metaData && metaData.storyId;
      var htmlEditorUriLocation = new URL(metaData.htmlEditorUri);
      var msId = metaData && new URLSearchParams(htmlEditorUriLocation.search).get('metaSiteId');
      if (storyId && msId) {
        fixedUrl = `${location.href.split('#')[0]}#!/builder/story/${storyId}:${msId}`;
      }
      return fixedUrl;
    }

    function getFixedUrlForMultipleStories(location) {
      var fixedUrl = location.href;
      var hashStory = location.hash.match(new RegExp('story/' + "(.*)" + ':'));
      if (hashStory && hashStory.length > 1) {
        var realStoryId = hashStory[1];
        var searchParamStoryId = new URLSearchParams(location.search).get('storyId');
        if (realStoryId !== searchParamStoryId) {
          fixedUrl = location.href.replace(searchParamStoryId, realStoryId);
        }
      }
      return fixedUrl;
    }

    function removeTrailingSlashes(url) {
      return url.replace(/\/+$/, "");
    }

    function getFixedUrl(url) {
      var fixedUrl = url.replace('#/!', '#!')
                        .replace(/#\/{0,}$/, '#!');
      var location = new URL(fixedUrl);

      if (location.search.indexOf('storyId=') !== -1) {
        if (location.hash.indexOf('/story/') !== -1) {
          fixedUrl = getFixedUrlForMultipleStories(location);
        } else {
          fixedUrl = getUrlWithoutParameter(location);
        }
      }
      return fixedUrl;
    }

    var currentUrl = window.location.href;
    var fixedUrl = getFixedUrl(currentUrl);
    if (removeTrailingSlashes(fixedUrl) !== removeTrailingSlashes(currentUrl)) {
      window.location.replace(fixedUrl);
    }
  </script>
  <script type="text/javascript">
      var commonConfig = {"brand":"wix"};
  </script>
  <script type="text/javascript">
    // 
    var ADI = {};

    ADI.getExperiments = function() {
      return {"specs.ob.upgradeTopbar":"true","specs.EnableMedReactForMobileEndpoint":"false","specs.ob.disableIntroStorage":"true","specs.ob.introChallengesTPA":"true","specs.ob.newAndUpdateKits":"true","specs.ob.med_oneAppDeepLinkWithOwnersAppDomain":"true","specs.ob.reactIntro":"true","specs.ob.adiOfflineFormsMigration":"true","specs.ob.formTitles":"true","specs.ob.fixStorePresets":"true","specs.ob.addPageFromLinkPopup":"true","specs.ob.fixDeserializeWidget":"true","specs.ob.lightboxSEO":"true","specs.ob.newResponsiveTopBar":"true","specs.ob.newContentManager":"true","specs.wossm.LimitNumOfFreeSites":"true","specs.ob.confirmFormHiding":"true","specs.ob.handleGtm":"true","specs.AdiMedReactIntroEnabled":"true","specs.ascend.AccessPackagePicker":"true","specs.wos.SiteHistoryBM":"true","specs.ValidateAutopilotMigration":"true","specs.ob.med_oneAppDeepLink":"true","specs.ob.TemplateFullStory":"true","specs.ob.noSearchRelatedResultsLabel":"true","specs.LimitContentSearchTerm":"true","specs.ob.setContentRole":"true","specs.ob.hideSendFeedback":"true","specs.ob.squeezeAllContacts":"true","specs.ob.newDealerApi":"true","specs.ob.addPendingAllMembers":"true","se_wixStores_ecomPlatformInstallation":"true","specs.ob.oldBlogRender":"true","specs.ob.pendingApps":"true","specs.ob.refComponentPoc":"true","specs.adi.EnableRedirectLangDomainToEditorDomain":"true","specs.ob.tpaPagesSupport":"true","specs.ob.med_migrateToHttpClient":"true","specs.ob.fixStripWithOneColumnSignature":"true","specs.ob.giftCard":"true","specs.ob.liveVideoForWixEventsMigration":"true","specs.ob.disableMMCustomTab":"true","specs.adi.EnableHardDeleteEvent":"true","specs.ob.confirmFormPresetChange":"true","specs.ob.fixSeoValidation":"true","specs.experts.FeedBackNg2":"true","specs.UseBoltInPreviewForAdi":"true","specs.ob.FormsPaymentOpenDashboard":"true","specs.vod.siteBased":"true","specs.adi.EnableNewLocalesInSearch":"false","specs.ob.tpaConfiguration":"true","specs.ob.notifyBmClosed":"true","specs.ob.platformsScreen4":"true","specs.ob.med_fixDesignFromDesktopBannerLink":"true","specs.ob.fixBlogAsHomepage":"true","specs.CompressStoryEvents":"true","specs.ob.fitnessNotification":"true","specs.ob.bookingsServicePageSettings":"true","specs.ob.challengesInstallPricingPlansMigration":"true","specs.ob.newTopBarTpa":"true","specs.ob.FormsPaymentADI":"true","specs.ob.tpaRemovePage":"true","specs.ob.loyaltyOnAdi":"true","specs.ob.fixMobileMenuToggle":"false","specs.ob.challengesInstallGroupsMigration":"true","specs.ob.med_blockPagesAddWithTPA":"true","specs.ob.AdiInstallBookCheckoutPage":"true","specs.ob.readSeoOnLoad":"true","specs.ob.showLoyaltyOnAdiAppPanel":"false","specs.ob.med_menuMarketplaceLink":"true","specs.media.MediaManager3Migrate":"true","specs.vod.useGraphAPI":"false","specs.ob.wixEvents":"true","specs.ob.moveProGalleryWithOriginCompId":"true","spec.ob.cleanTechDebt":"true","specs.ob.limitMaxPageAmount":"true","specs.ob.med_oneAppNewDeepLink":"true","specs.funnel.EnableNewCreateSiteUrl":"true","specs.adi.EnableRedirectToEditorDomain":"true","specs.ob.ignorePendingAppErrors":"true","specs.ob.tpaSectionError":"true","specs.ob.blogGoToEditor":"true","specs.media.MediaManager3":"true","specs.ob.deleteAdiIntro":"true","specs.ob.enableNewScoreForDefaultContent":"true","specs.ob.med_videoUploader":"true","specs.ob.newBusinessQuestions":"false"};
    };

    ADI.messageQueue = [];
    ADI.messagesSaver = function(event) {
      ADI.messageQueue.push(event);
    };
    window.addEventListener('message', ADI.messagesSaver);

    (function (window) {
      var guidRegex = '[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}';
      var siteIdRegex = new RegExp('/builder/story/(' + guidRegex + '):(' + guidRegex + ')', 'i');
      ADI.siteId = siteIdRegex.exec(window.location.hash);
    })(window);

    (function (window) {
      function redirectToURLWithStoryId(storyId) {
        var storyIdParam = 'storyId=' + storyId;
        var prefix = window.location.search.length === 0 ? '?' : '&';
        window.location.search += prefix + storyIdParam;
        throw new Error('storyId query parameter is missing - redirecting');
      }

      var storyId = ADI.siteId && ADI.siteId[1];
      var hasStoryIdParam = /\bstoryId=/.test(window.location.search);
      var hasTemplateStoryIdParam = /\btemplateStoryId=/.test(window.location.search);
      if (storyId && !hasStoryIdParam && !hasTemplateStoryIdParam) {
        redirectToURLWithStoryId(storyId);
      }
    })(window);

    (function (window) {
      ADI.getParameterByName = function(name, url) {
        if (!url) url = window.location.href;
        name = name.replace(/[\[\]]/g, '\\$&');
        var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, ' '));
      }
    })(window);

     // fedops
    (function () {
      if (!ADI.siteId) {
        return;
      }

      var appName = 'site-generator-statics-consumer';
      window.fedops = window.fedops || {};
      window.fedops.apps = window.fedops.apps || {};
      window.fedops.apps[appName] = {startLoadTime: performance && performance.now && performance.now()};
      window.fedops = window.fedops || {};
      window.fedops.sessionId = window.localStorage.getItem('fedops.logger.sessionId') || 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
      });
      (new Image()).src = '//frog.wix.com/fed?appName=' + appName + '&src=72&evid=14&session_id=' + window.fedops.sessionId;
    })();

    ADI.getTimestamp = typeof performance === 'object' && typeof performance.now === 'function'
      ? function () {return performance.now()}
      : function () {return Date.now()};

    //fire start open here
    (function (window) {
      if (!ADI.siteId) {
        return;
      }

      ADI.loadStartTime = ADI.getTimestamp();
      ADI.isTemplate = window.location.href.indexOf('templateSite=true') >= 0 || /\btemplateStoryId=/.test(window.location.search);

      var instanceId = ADI.siteId[1];
      var msid = ADI.siteId[2];
      var loadType = ADI.isTemplate ? 'template' : 'existing%20site';
      ADI.headlessApi = window.location.hash.indexOf('headlessApi') !== -1;

      var silentBIValue = ADI.getParameterByName('silentBI');
      var silentBI = silentBIValue === '' || silentBIValue === 'true';
      if (!silentBI) {
        var viewerName = (ADI.getExperiments() || {})['specs.UseBoltInPreviewForAdi'] === 'true' ? 'bolt' : 'santa';
        if (!ADI.headlessApi) {
          (new Image()).src = '//frog.wix.com/onboarding?src=66&evid=135&origin=home' +
              '&instanceId=' + instanceId +
              '&msid=' + msid +
              '&loadType=' + loadType +
              '&viewerName=' + viewerName +
              '&esi=4194c372-d6d1-4ece-9b95-4eecd35d8c38';

          (new Image()).src = '//frog.wix.com/fed?appName=site-generator-statics-consumer' +
            '&name=init%20existing' +
            '&src=72' +
            '&evid=15' +
            '&viewerName=' + viewerName +
            '&session_id=' + window.fedops.sessionId +
            '&_=' + new Date().getTime();
          // add interaction manually so later call to interactionEnded() works
          window.fedops.apps['site-generator-statics-consumer'].interactions = window.fedops.apps['site-generator-statics-consumer'].interactions || {};
          window.fedops.apps['site-generator-statics-consumer'].interactions['init existing'] = {timestamp: performance && performance.now && performance.now()};
        }

        (new Image()).src = '//frog.wix.com/onboarding?src=66&evid=1&origin=home' +
                '&phaseName=pre%20init' +
                '&subPhaseName=' +
                '&msid=' + msid +
                '&esi=4194c372-d6d1-4ece-9b95-4eecd35d8c38' +
                '&loadType=' + loadType +
                '&viewerName=' + viewerName +
                '&loadTime=' + Math.round(ADI.loadStartTime);
      }
    })(window);
    //   </script>

  <script type="text/javascript">
    ADI.getMetadata = function() {
      return ;
    };

    ADI.videoLoaderSrc = 'https://static.parastorage.com/services/adi-web/2.5376.0/assets/videos/loader.mp4';

    //measure time
    (function (window) {
      var totalTabVisibleTime, tabVisibleStartTime;

      var visibilitychangeHandler = function visibilitychangeHandler() {
        if (document.hidden) { // blur tab
          totalTabVisibleTime += ADI.getTimestamp() - tabVisibleStartTime;
        } else { // focus tab
          tabVisibleStartTime = ADI.getTimestamp();
        }
      };

      ADI.measureTimeInTab = {
        start: function () {
          totalTabVisibleTime = 0;
          tabVisibleStartTime = !document.hidden && ADI.getTimestamp();
          document.addEventListener('visibilitychange', visibilitychangeHandler);
        },
        end: function () {
          document.removeEventListener('visibilitychange', visibilitychangeHandler);
          if (!document.hidden) {
            totalTabVisibleTime += ADI.getTimestamp() - tabVisibleStartTime;
          }
          return Math.round(totalTabVisibleTime);
        }
      };

      ADI.measureTimeInTab.start();
    })(window);
  </script>

  <!-- Sentry SDK CDN Loader -->
  <script src="https://browser.sentry-cdn.com/5.5.0/bundle.min.js" crossorigin="anonymous"></script>
  <script type="text/javascript">
    // if Sentry failed to load, could happen when using certain ad blocks.
    if (typeof Sentry === 'undefined') {
      var Sentry = undefined;
    }
    Sentry && Sentry.init({ dsn: 'https://2e21bb4dae02428f9a177b942abc4832@sentry.wixpress.com/205' });
  </script>

  <script type="text/javascript">
    ADI.openPanel = ADI.getParameterByName('openPanel');
    ADI.focusSpecificAppInPanel = ADI.getParameterByName('openpanel'); // for marketing!
    ADI.etpa = ADI.getParameterByName('etpa'); // for marketing!

    ADI.fixOrigin = function(url, forceHttps) {
      if ((location.protocol === 'https:' || forceHttps) && url.indexOf('http:') === 0) {
        url = 'https:' + url.substr('http:'.length);
      }

      if (url.indexOf('//') === 0) {
        var protocol = forceHttps ? 'https:' : location.protocol;
        return protocol + url;
      }

      if (url.indexOf('://www.') === -1) {
        return url;
      } else {
        return url.replace(/:\/\/www\./g, '://' + window.location.host.substr(0, window.location.host.indexOf('.')) + '.');
      }
    };
  </script>

  <link rel="stylesheet" href="https://static.parastorage.com/services/third-party/fonts/Helvetica/fontFace.css">

  <link rel="stylesheet" href="https://static.parastorage.com/unpkg/angular-material@1.1.0-rc.5/angular-material.min.css">

  <!--  -->
    <link rel="stylesheet" href="https://static.parastorage.com/services/adi-web/2.5376.0/intro-react-js.min.css">
  <!-- reactIntro  -->

  <link rel="stylesheet" href="https://static.parastorage.com/services/adi-web/2.5376.0/first-parties-css.min.css">

  <link rel="stylesheet" href="https://static.parastorage.com/services/adi-web/2.5376.0/fonts2-css.min.css">

  <script type="text/javascript">
    //fix cross domain issue
    document.domain = window.location.hostname.split('.').slice(-2).join('.');

    window.onerror = function() {
      window.onerror.errors.push([].slice.call(arguments));
    };
    window.onerror.errors = [];
  </script>
</head>
<body assistant-stop-on-escape ng-controller="AppCtrl as $ctrl" data-state="{{$ctrl.state}}"
      ng-class="{'assistant-on': $ctrl.isAssistantOn, '-is-tpa': $ctrl.isTpa}" style="background: #fafafa;">
  <!-- Google Tag Manager (noscript) -->
  <noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-MDD5C4"
  height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
  <!-- End Google Tag Manager (noscript) -->

<app-main> <!-- Ui views didnt work in a template for some reason -->
  <div class="content">
    <builder></builder>
    <div class="content-inner" ui-view="" state-class=""></div>
  </div>
</app-main>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD0Rix35PXdJPNLrhvZqUeWcJSDekqFkb8&libraries=places&language=ko"></script>
<script src="//static.parastorage.com/services/cookie-consent-policy-client/1.573.0//app.bundle.min.js"></script>
<script src="//static.parastorage.com/services/tag-manager-client/1.427.0//hostTags.bundle.min.js"></script>
<script type="text/javascript">
  (function (window) {
    if (window.consentPolicyManager && window.consentPolicyManager.init) {
      window.consentPolicyManager.init({
        baseUrl: `https://www.wix.com`,
        consentPolicy: {"functional":true,"analytics":true,"advertising":true,"dataToThirdParty":true,"essential":true},
      });
    }
    if (window.wixTagManager) {
      window.wixTagManager.init(window.wixTagManager.HOST_NAMES.ADI, 'ko');
    }
  })(window);
</script>

<script src="//static.parastorage.com/services/editor-platform-host-integration/1.1357.0//editor-platform-host-integration.umd.min.js"></script>
<script src="https://static.parastorage.com/unpkg-semver/media-frame@%5E1/MediaFrame.bundle.min.js"></script>
<script src="https://static.parastorage.com/services/media-manager-api/1.906.0/media-manager-api.js" crossorigin="anonymous"></script>
<script src="https://static.parastorage.com/unpkg/jquery@2.2.4/dist/jquery.min.js" crossorigin="anonymous"></script>
<script type="text/javascript">
  (function (window) {
    if (ADI.isTemplate) {
      ADI.templateStoryId = ADI.getParameterByName('templateStoryId') || true;
      var newUrl = location.href.replace(/&templateStoryId=[^&#]*|templateStoryId=[^&#]*&/, '')
                                .replace(/templateSite=true(\/?)/, '')
                                .replace('?&', '?').replace('&&', '&')
                                .replace('&#', '#').replace('?#', '#');
      history.replaceState({}, '', newUrl);

      var loaderContainer = document.createElement('div');
      loaderContainer.id = 'videoLoader';
      loaderContainer.style.cssText = 'width: 100vw; height: 100vh; display: flex; justify-content: center; background: #fff;';
      loaderContainer.innerHTML += '<video autoplay muted>' +
          '<source src="https://d2x3xhvgiqkx42.cloudfront.net/12345678-1234-1234-1234-1234567890ab/c89028dc-062f-4fbf-a360-03018d49c998/2018/12/12/6cc94596-18f2-482d-96a8-838ded8d36b0.mp4" type="video/mp4" />' +
        '</video>';
      document.body.appendChild(loaderContainer);
      document.body.classList.add('loading-site');
    }

    if (!ADI.siteId || window.location.href.indexOf('previewRevision=') >= 0 || ADI.isTemplate) {
      return;
    }

    var storyId = ADI.siteId[1] + ':' + ADI.siteId[2];
    var url = '/_api/onboarding-server-web/story/' + storyId;
    url += '?cacheKiller=' + Date.now();
    url += '&editorSessionId=4194c372-d6d1-4ece-9b95-4eecd35d8c38';
    ADI.storyCache = {};
    ADI.storyCache[storyId] = $.get(url);
  })(window);
</script>

<script type="text/javascript">
  (function (window) {
    var resApi, res;
    if (typeof Promise !== 'undefined') {
      window.resApiLoaded = new Promise(function (resolve, reject) {
        resApi = resolve;
      });

      window.signalApiLoaded = function() {
        resApi && resApi();
      };

      window.headlessReady = new Promise(function (resolve, reject) {
        res = resolve;
      });

      window.signalHeadlessReady = function() {
        res && res();
      };
    }
  })(window);
</script>

<script src="https://www.google.com/recaptcha/api.js?onload=onLoadRecaptchaCallback&render=explicit" async defer></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular@1.5.11/angular.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-i18n@1.5.11/angular-locale_ko.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-animate@1.5.11/angular-animate.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/lodash@4.17.11/lodash.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-sanitize@1.5.11/angular-sanitize.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-translate@2.17.0/dist/angular-translate.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-aria@1.5.11/angular-aria.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-messages@1.5.11/angular-messages.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-material@1.1.0-rc.5/angular-material.min.js"></script>

<script crossorigin="anonymous" src="//static.parastorage.com/services/site-generator-statics-metadata/1.1703.0/scripts/scripts.js"></script>

<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/es6-shim@0.35.3/es6-shim.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/@cgross/angular-notify@2.5.1/dist/angular-notify.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/@wix/js-sdk-commons@1.0.448/dist/scripts/scripts.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-elastic@2.5.1/elastic.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-local-storage@0.2.7/dist/angular-local-storage.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-ui-tree@2.22.6/dist/angular-ui-tree.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-ui-router@0.2.18/release/angular-ui-router.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/tinycolor2@1.4.1/dist/tinycolor-min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/color-thief@1.0.317"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angularjs-color-picker@2.7.2/dist/angularjs-color-picker.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-xeditable@0.1.12/dist/js/xeditable.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-socialshare@2.3.11/dist/angular-socialshare.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/angular-drag-and-drop-lists@1.4.0/angular-drag-and-drop-lists.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/ng-sortable@1.3.7/dist/ng-sortable.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/gsap@1.20.4/Draggable.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/gsap@1.20.4/TweenMax.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/jquery-tooltipster@3.3.0/js/jquery.tooltipster.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/seedrandom@2.4.3/seedrandom.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/polymer-weakmap@0.0.0/weakmap.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/@wix/wix-angular@1.0.700/dist/wix-angular.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/@wix/wix-angular@1.0.700/dist/wix-angular-storage.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/jszip@2.6.1/dist/jszip.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/jszip-utils@0.0.2/dist/jszip-utils.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/webfontloader@1.6.6/webfontloader.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/stackblur-canvas@1.4.1/dist/stackblur.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/rxjs@6.4.0/bundles/rxjs.umd.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/chroma-js@2.0.1/chroma.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/bluebird@2.11.0/js/browser/bluebird.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/@wix/wix-richtext@2.816.0/dist/NoUIBundleWixRichText.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/fast-json-patch@2.0.7/dist/fast-json-patch.min.js"></script>

<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/react@16.8.4/umd/react.production.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg/react-dom@16.8.4/umd/react-dom.production.min.js"></script>

<script crossorigin="anonymous" src="https://static.parastorage.com/unpkg-semver/wix-recorder@^1/app.bundle.min.js"></script>

<script type="text/javascript">
  window.AnswersWidget = {
    onLoaded: function(callback) {
      window.AnswersWidget.queue.push(callback);
    },
    queue: [function() {
      window.AnswersWidget.hide();
    }],
  };
</script>

<script src="https://wix-adi.wixanswers.com/apps/widget/v1/wix-adi/8ca0db76-4f0e-4ebe-99ac-2429b80bf5bf/en/embed.js"></script>

<script crossorigin="anonymous" src="https://static.parastorage.com/services/adi-web/2.5376.0/third-parties-clean-js.bundle.min.js"></script>
<!--  -->
<script crossorigin="anonymous" src="https://static.parastorage.com/services/adi-web/2.5376.0/second-parties-js.bundle.min.js"></script>

<!--  -->

<script>
  ADI.clientTopology = {
    production: 'false' !== 'true',
    staticsVersion: '2.5376.0',
    staticsUrl: 'https://static.parastorage.com/services/adi-web/2.5376.0/',
    staticBaseUrl: 'https://static.parastorage.com/',
    experiments: ADI.getExperiments(),
    siteMediaToken: (ADI.getMetadata() || {}).siteMediaToken,
    isNewSite: !ADI.getMetadata(),
    mediaUrl: '//static.wixstatic.com/media',
    videoUrl: 'https://video.wixstatic.com/',
    filesBaseUrl: '//docs.wixstatic.com/',
    editorBaseUrl: ADI.fixOrigin('http://editor.wix.com', false),
    baseDomain: 'wix.com',
    contentVersionNumber: '${contentVersionNumber}',
    esi: '4194c372-d6d1-4ece-9b95-4eecd35d8c38',
    isWixStaff: false,
    isAnonymous: false,
    hasSession: true,
    isImpersonatedUser: false,
    isTemplatesUser: false,
    schedulerBaseUrl: ADI.fixOrigin('http://scheduler.wix.com', false),
    appsBaseUrl: 'https://apps.wix.com',
    businessManagerBaseUrl: ADI.fixOrigin('https://manage.wix.com/dashboard', false),
    locale: 'ko',
    templateTranslationServerBaseUrl: '${clientTopology.templateTranslationUrl}',
    mediaGalleryUrl: 'https://www.wix.com/_partials/media-gallery-g5/1.1506.0/',
    mediaManagerPartialsUrlG6: 'https://www.wix.com/_partials/media-manager-g6/1.1900.0/',
    santaEditorStaticsUrl: '//static.parastorage.com/services/santa-editor/1.13610.0/'
  };
</script>

<!--  -->
  <script crossorigin="anonymous" src="https://static.parastorage.com/services/adi-web/2.5376.0/intro-react-js.bundle.min.js"></script>
<!-- reactIntro  -->

<script crossorigin="anonymous" src="https://static.parastorage.com/services/adi-web/2.5376.0/first-parties-js.bundle.min.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/services/adi-web/2.5376.0/assets/locale/messages_ko.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/services/adi-web/2.5376.0/assets/common-controls/locale/messages_ko.js"></script>
<script crossorigin="anonymous" src="https://static.parastorage.com/services/adi-web/2.5376.0/assets/organize-media/locale/messages_ko.js"></script>

<script>
  angular.module('siteGeneratorCommon')
    .constant('clientTopology', ADI.clientTopology)
    .constant('metaDataBaseUrl', ADI.fixOrigin('//static.parastorage.com/services/site-generator-statics-metadata/1.1703.0/', true))
    .constant('metaDataUrl', '//static.parastorage.com/services/site-generator-statics-metadata/1.1703.0/scripts')
    .constant('metaDataVersion', '');
</script>

  <div class="svgs-icons-container"
     style="position: absolute; z-index: -9999; width: 0; height: 0; top: -10000px; left: -10000px;">
  <ng-include
      src="'https://static.parastorage.com/services/adi-web/2.5376.0/assets/common-controls/svg-sprites-complex/icons.sprite.svg'"></ng-include>
    <ng-include
      src="'https://static.parastorage.com/services/adi-web/2.5376.0/assets/common-controls/svg-sprites/icons.sprite.svg'"></ng-include>
  </div>

  <!--  -->

  <!--  -->

  <script>
      ADI.lazyLoadCss = function(src) {
        var flink = document.getElementsByTagName('link')[0];
        var link = document.createElement('link');
        link.rel='stylesheet'
        link.href = src;
        flink.parentNode.insertBefore(link, flink);
      };
  </script>

  <script>ADI.lazyLoadCss('https://static.parastorage.com/services/adi-web/2.5376.0/third-parties-css.min.css');</script>
  <script>ADI.lazyLoadCss('https://static.parastorage.com/services/adi-web/2.5376.0/first-parties-js.min.css');</script>
</body>
</html>
