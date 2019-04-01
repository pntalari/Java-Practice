package com.zipcoder.quiz5;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CommonWordTest {
    CommonWord commonWord = new CommonWord();

    @Test
    public void testCount_forOneWord(){
        String text = "apple";

        List<Entry> counts = commonWord.getCommonWord(text);
        Assert.assertEquals(1, counts.size());


        int actualCount = counts.get(0).getCount();
        Assert.assertEquals(1, actualCount);
    }

    @Test
    public void testCount_forTheSameWord(){
        String text = "apple Apple orange apple orange";

        List<Entry> counts = commonWord.getCommonWord(text);
        Assert.assertEquals(1, counts.size());


        int actualCount = counts.get(0).getCount();
        Assert.assertEquals(5, actualCount);
    }

    @Test
    public void testCount_forDifferentWords(){
        String text = "apple orange apple";

        List<Entry> counts = commonWord.getCommonWord(text);
        Assert.assertEquals(2, counts.size());


        Entry apple = counts.get(0);
        Assert.assertEquals(2, apple.getCount());

        Entry orange = counts.get(1);
        Assert.assertEquals(1, orange.getCount());
    }

    @Test
    public void testCount_forSameWordCount(){
        String text = "apple orange orange apple";

        List<Entry> counts = commonWord.getCommonWord(text);
        Assert.assertEquals(2, counts.size());


        Entry word1 = counts.get(0);
        Assert.assertEquals(2, word1.getCount());

        Entry word2 = counts.get(1);
        Assert.assertEquals(2, word2.getCount());
    }

    @Test
    public void testCount_forLargeText(){
        String text = "Come on come on I see no changes wake up in the morning and I ask myself Is life worth living should I blast myself? I'm tired of bein' poor and even worse I'm black My stomach hurts so I'm lookin' for a purse to snatch Cops give a damn about a negro Pull the trigger kill a nigga he's a hero Give the crack to the kids who the hell cares One less hungry mouth on the welfare First ship 'em dope and let 'em deal the brothers Give 'em guns step back watch 'em kill each other It's time to fight back that's what Huey said Two shots in the dark now Huey's dead I got love for my brother but we can never go nowhere Unless we share with each other We gotta start makin' changes Learn to see me as a brother instead of two distant strangers And that's how it's supposed to be How can the Devil take a brother if he's close to me? I'd love to go back to when we played as kids But things changed, and that's the way it is That's just the way it is Things will never be the same That's just the way it is Aww yeah That's just the way it is Things will never be the same That's just the way it is Aww yeah I see no changes all I see is racist faces Misplaced hate makes disgrace to races We under I wonder what it takes to make this One better place, let's erase the wasted Take the evil out the people they'll be acting right 'Cause both black and white is smokin' crack tonight And only time we chill is when we kill each other It takes skill to be real, time to heal each other And although it seems heaven sent We ain't ready, to see a black President, uhh It ain't a secret don't conceal the fact The penitentiary's packed, and it's filled with blacks But some things will never change Try to show another way but you stayin' in the dope game Now tell me what's a mother to do Bein' real don't appeal to the brother in you You gotta operate the easy way \"I made a G today\" But you made it in a sleazy way Sellin' crack to the kid. \" I gotta get paid,\" Well hey, well that's the way it is That's just the way it is Things will never be the same That's just the way it is Aww yeah That's just the way it is Things will never be the same That's just the way it is Aww yeah We gotta make a change It's time for us as a people to start makin' some changes. Let's change the way we eat, let's change the way we live And let's change the way we treat each other. You see the old way wasn't working so it's on us to do What we gotta do, to survive. And still I see no changes can't a brother get a little peace It's war on the streets and the war in the Middle East Instead of war on poverty they got a war on drugs So the police can bother me And I ain't never did a crime I ain't have to do But now I'm back with the blacks givin' it back to you Don't let 'em jack you up, back you up, Crack you up and pimp smack you up You gotta learn to hold ya own They get jealous when they see ya with ya mobile phone But tell the cops they can't touch this I don't trust this when they try to rush I bust this That's the sound of my tool you say it ain't cool My mama didn't raise no fool And as long as I stay black I gotta stay strapped And I never get to lay back 'Cause I always got to worry 'bout the pay backs Some buck that I roughed up way back Comin' back after all these years Rat-a-tat-tat-tat-tat that's the way it is uhh That's just the way it is Things will never be the same That's just the way it is Aww yeah That's just the way it is Things will never be the same That's just the way it is Aww yeah Some things will never change";

        List<Entry> counts = commonWord.getCommonWord(text);


        Entry entry1 = counts.get(0);
        Assert.assertEquals(51, entry1.getCount());

        Entry entry2 = counts.get(1);
        Assert.assertEquals(26, entry2.getCount());

        Entry entry3 = counts.get(2);
        Assert.assertEquals(23, entry3.getCount());
    }
}
