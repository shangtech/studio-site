package net.shangtech.studio.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.entity.Photographer;
import net.shangtech.studio.entity.SpecialPage;
import net.shangtech.studio.entity.Style;
import net.shangtech.studio.service.IPhotoWorksService;
import net.shangtech.studio.service.IPhotographerService;
import net.shangtech.studio.service.ISpecialPageService;
import net.shangtech.studio.service.IStyleService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
@ContextConfiguration({
	"classpath*:spring.xml"
})
public class AppTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired private IPhotographerService photographerService;
	@Autowired private IPhotoWorksService worksService;
	@Autowired private IStyleService styleService;
	@Autowired private ISpecialPageService specialService;
	
	private static final Random R = new Random();
	
	@Test
	public void generateTestDatas(){
		long pcount = 35;//摄影师人数
		long wcount = 32;//每个摄影师作品数量
		long spcount = 14;//special-page数量
		long scount = 14;//风格数量
		List<PhotoWorks> worksList = new ArrayList<>();
		for(int i = 0; i < pcount; i++){
			Photographer photographer = photographer();
			photographerService.save(photographer);
			for(int j = 0; j < wcount; j++){
				PhotoWorks works = works(photographer);
				worksService.save(works);
				worksList.add(works);
			}
		}
		for(int i = 0; i < scount; i++){
			Style style = style(i);
			styleService.save(style);
			Set<Integer> set = new HashSet<>();
			while(set.size() < scount){
				set.add(R.nextInt(worksList.size()));
			}
			set.forEach(index -> {
				PhotoWorks works = worksList.get(index);
				styleService.addWorksToStyle(works.getId(), style.getId());
			});
		}
		for(int i = 0; i < spcount; i++){
			SpecialPage special = special();
			specialService.save(special);
		}
	}
	
	private Photographer photographer(){
		Date now = new Date();
		Photographer photographer = new Photographer();
		photographer.setAppointments(String.valueOf(R.nextInt(1000)));
		photographer.setDescription("摄影师描述摄影师描述摄影师描述摄影师描述摄影师描述摄影师描述-" + now.getTime());
		photographer.setExperience(R.nextInt(10) + 1 + "年");
		photographer.setMembers("(造型师,灯光师,摄影师)");
		photographer.setName("摄影师-" + now.getTime());
		photographer.setPrice(4000 + R.nextInt(2000) + "/天");
		photographer.setUrl("photographer-" + now.getTime());
		return photographer;
	}
	
	private PhotoWorks works(Photographer photographer){
		Date now = new Date();
		PhotoWorks works = new PhotoWorks();
		works.setAuthor(photographer.getId());
		works.setAddress("北京");
		works.setDescription("描述描述描述-" + now.getTime());
		works.setHearts(String.valueOf(R.nextInt(1000)));
		works.setName("作品-" + now.getTime());
		works.setUrl("works-" + now.getTime());
		return works;
	}
	
	private Style style(int i){
		Date now = new Date();
		Style style = new Style();
		style.setMemo("memo");
		style.setName("风格" + i);
		style.setUrl("style-" + now.getTime());
		return style;
	}
	
	private SpecialPage special(){
		Date now = new Date();
		SpecialPage special = new SpecialPage();
		special.setName("页面-" + now.getTime());
		special.setPageContent("页面内容-" + now.getTime());
		special.setPageDescription("页面描述-" + now.getTime());
		special.setPageKeyWords("页面关键字-" + now.getTime());
		special.setPageTitle("页面标题-" + now.getTime());
		special.setShowAppointment(R.nextInt()%2 == 0);
		special.setShowTel(!special.getShowAppointment());
		special.setUrl("special-" + now.getTime());
		return special;
	}
}
